package interview.randomaccessfile;

import java.io.*;
import java.util.Scanner;

public class FileOperate {

    private static int position = -1;

    public static void main(String[] args) {
        // 源文件与目标文件
        File sourceFile = new File("/Users/mac/ideaproject/gitlearn/learn/src/main/java/interview/randomaccessfile" +
                "/test");
        File targetFile = new File("/Users/mac/ideaproject/gitlearn/learn/src/main/java/interview/randomaccessfile" +
                "/write");
        // 输入输出流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        // 数据缓冲区
        byte[] buf = new byte[1];

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);
            // 数据读写
            while (fis.read(buf) != -1) {
                fos.write(buf);
                // 当已经上传了3字节的文件内容时，网络中断了，抛出异常
                if (targetFile.length() == 3) {
                    position = 3;
                    throw new FileAccessException();
                }
            }
        } catch (FileAccessException e) {
            keepGoing(sourceFile, targetFile, position);
        } catch (FileNotFoundException e) {
            System.out.println("指定文件不存在");
        } catch (IOException e) {
            // TODO: handle exception
        } finally {
            try {
                // 关闭输入输出流
                if (fis != null)
                    fis.close();

                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private static void keepGoing(File source, File target, int position) {
        try {
            Thread.sleep(5000);
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter yes to continue: ");
            if (!"yes".equals(sc.next())) {
                System.out.println("terminal");
                return;
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            RandomAccessFile readFile = new RandomAccessFile(source, "rw");
            RandomAccessFile writeFile = new RandomAccessFile(target, "rw");
            readFile.seek(position);
            writeFile.seek(position);

            // 数据缓冲区
            byte[] buf = new byte[1];
            // 数据读写
            while (readFile.read(buf) != -1) {
                writeFile.write(buf);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static class FileAccessException extends Exception {
    }
}
