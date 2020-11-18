package io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Scanner;

public class basicChannel {
    public static void main(String[] args) throws Exception {

        //String path = basicChannel.class.getResource("/").getPath();
        //FileInputStream fis = new FileInputStream(new File(path + "test.txt"));

        try (FileInputStream fileInputStream = new FileInputStream("/Users/fxs/IdeaProjects/learn/src/main/java/io/nio/test");
             FileOutputStream fileOutputStream = new FileOutputStream("/Users/fxs/IdeaProjects/learn/src/main/java/io/nio/test")
        ) {

        }


        RandomAccessFile file = new RandomAccessFile("/Users/fxs/IdeaProjects/learn/src/main/java/io/nio/test", "rw");
        FileChannel channel = file.getChannel();
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        ByteBuffer buffer = ByteBuffer.allocate(128);
        CharBuffer charBuffer = CharBuffer.allocate(128);

        //Write
//        buffer.putChar('数');
//        buffer.flip();
//        channel.write(buffer);

        //Reads a sequence of bytes from this channel into the given buffer.
        int read = channel.read(buffer);
        while (read != -1) {
            buffer.flip();
            decoder.decode(buffer, charBuffer, false);
            charBuffer.flip();
            while (charBuffer.hasRemaining()) {
                char c = charBuffer.get();
                System.out.print(c);
            }
            buffer.clear();
            charBuffer.clear();
            read = channel.read(buffer);
        }
        channel.close();
        file.close();

        try (Scanner scanner = new Scanner(System.in);) {
            while (true) {
                String s = scanner.nextLine();
                System.out.print(s + "\n");
            }

        }


    }

    protected void protectedMethod() {

    }
}
