package io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PIpeTest {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        //写数据
        Pipe.SinkChannel sinkChannel = pipe.sink();
        //读数据
        Pipe.SourceChannel sourceChannel = pipe.source();


        String test = "now time" + System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();

        byteBuffer.put(test.getBytes());

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            sinkChannel.write(byteBuffer);
        }

        int read = sourceChannel.read(readBuffer);

        while (read != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                byte b = byteBuffer.get();
                byte[] array = byteBuffer.array();
                System.out.print((char) b);
            }
            byteBuffer.clear();
            byteBuffer.compact();
            read = sourceChannel.read(readBuffer);
        }

        System.out.print("");
    }
}
