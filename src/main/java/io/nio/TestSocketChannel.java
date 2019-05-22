package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TestSocketChannel {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.clear();
    }
}
