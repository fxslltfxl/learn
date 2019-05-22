package charset;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class CharSetPro {
    public static void main(String[] strings) {
        String str = "你";
        char[] cha = {'你'};
        int i = 300;
        try {
            String a=""+"";
//            System.out.println(getBytes(cha).length);
//            // 这种强转 存在问题 '你' '`' 编码
            System.out.println((byte) '你');
            System.out.println((byte) '`');

            System.out.println("汉字不同编码格式所占字节数");
            System.out.println(str.getBytes("utf-8").length);
            System.out.println(str.getBytes("utf-16").length);
            System.out.println(str.getBytes("gbk").length);
            System.out.println(str.getBytes("unicode").length);

            System.out.println("数字与字母不同编码格式所占字节数");
            System.out.println("1".getBytes("utf-8").length);
            System.out.println("A".getBytes("utf-8").length);
            System.out.println("1".getBytes("utf-16").length);
            System.out.println("A".getBytes("utf-16").length);
            System.out.println("1".getBytes("gbk").length);
            System.out.println("A".getBytes("gbk").length);
            System.out.println("1".getBytes("unicode").length);
            System.out.println("A".getBytes("unicode").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // char转byte
    private static byte[] getBytes(char[] chars) {
        Charset cs = Charset.forName("UTF-8");
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);
        return bb.array();
    }

    // byte转char

    private char[] getChars(byte[] bytes) {
        Charset cs = Charset.forName("UTF-8");
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.put(bytes);
        bb.flip();
        CharBuffer cb = cs.decode(bb);
        return cb.array();
    }
}
