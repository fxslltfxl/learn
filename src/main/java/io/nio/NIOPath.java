package io.nio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOPath {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/fxs/IdeaProjects/learn/src/main/java/io/nio/test");
        Path fileName = path.getFileName();

        File file = fileName.toFile();

        basicChannel basicChannel = new basicChannel();
        basicChannel.protectedMethod();
    }
}
