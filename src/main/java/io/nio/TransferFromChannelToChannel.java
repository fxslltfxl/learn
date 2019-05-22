package io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 两个channel之间传递数据
 */
public class TransferFromChannelToChannel {
    public static void main(String[] args) throws IOException {

        RandomAccessFile src = new RandomAccessFile("/Users/fxs/IdeaProjects/learn/src/main/java/io/nio/test", "rw");
        RandomAccessFile dest = new RandomAccessFile("/Users/fxs/IdeaProjects/learn/src/main/java/io/nio/file", "rw");
        FileChannel channelSrc = src.getChannel();
        FileChannel channelDest = dest.getChannel();

        channelDest.transferFrom(channelSrc, 0, channelSrc.size());






    }
}
