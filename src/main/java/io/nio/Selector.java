package io.nio;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Selector {
    public static void main(String[] args) throws IOException {

        java.nio.channels.Selector selector = java.nio.channels.Selector.open();
        ServerSocketChannel open = ServerSocketChannel.open();
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        SelectionKey register = channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT);
        // SelectionKey 的interest
        int interestSet = register.interestOps();
        boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
        boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;
        boolean isInterestedInRead = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;
        boolean isInterestedInWrite = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;



        while (true){
            java.nio.channels.Selector selector1 = register.selector();
            int select = selector1.select();
            if (select==0) continue;

            Set<SelectionKey> selectionKeys = selector1.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isAcceptable()){
                    ServerSocketChannel channel1 = (ServerSocketChannel) next.channel();
                }
                else if (next.isConnectable()){}
                else if (next.isReadable()){}
                else if (next.isWritable()){}
                else {}
                iterator.remove();
            }
        }


    }
}
