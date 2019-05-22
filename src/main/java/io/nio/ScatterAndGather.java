package io.nio;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO开始支持scatter/gather，scatter/gather用于描述从Channel（译者注：Channel在中文经常翻译为通道）
 * 中读取或者写入到Channel的操作。
 * 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
 * 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。
 * <p>
 * scatter / gather经常用于需要将传输的数据分开处理的场合，例如传输一个由消息头和消息体组成的消息，
 * 你可能会将消息体和消息头分散到不同的buffer中，这样你可以方便的处理消息头和消息体
 */
public class ScatterAndGather {
    public static void main(String[] args) throws IOException {

        RandomAccessFile file = new RandomAccessFile("/Users/fxs/IdeaProjects/learn/src/main/java/io/nio/test", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer head = ByteBuffer.allocate(4);
        ByteBuffer body = ByteBuffer.allocate(128);

        ByteBuffer[] buffers = {head, body};

        long read = channel.read(buffers);

        while (read != -1) {
            buffers[0].flip();
            buffers[1].flip();

            while (head.hasRemaining()) {
                System.out.print((char) head.get());
            }
            while (body.hasRemaining()) {
                System.out.print((char) body.get());
            }

            //一旦读完Buffer中的数据，需要让Buffer准备好再次被写入。可以通过clear()或compact()方法来完成。
            //如果调用的是clear()方法，position将被设回0，limit被设置成 capacity的值。换句话说，Buffer 被清空了。Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据。
            //如果Buffer中有一些未读的数据，调用clear()方法，数据将“被遗忘”，意味着不再有任何标记会告诉你哪些数据被读过，哪些还没有。
            //如果Buffer中仍有未读的数据，且后续还需要这些数据，但是此时想要先先写些数据，那么使用compact()方法。
            //compact()方法将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
            head.compact();
            body.compact();

            // Buffer.rewind()将position设回0，
            // 所以你可以重读Buffer中的所有数据。
            // limit保持不变，仍然表示能从Buffer中读取多少个元素（byte、char等）。

//            通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。
//            之后可以通过调用Buffer.reset()方法恢复到这个position
//            head.mark();
//            buffer.reset();  //set position back to mark.

            read = channel.read(buffers);
        }
        head.clear();
        body.clear();
        channel.close();
        file.close();


    }
}
