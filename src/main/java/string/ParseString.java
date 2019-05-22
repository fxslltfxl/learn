package string;

import java.lang.reflect.Field;

public class ParseString {
    public static void main(String[] args) throws Exception {
//        String str = "XWW";
//
//        str.replace("X","F");
//        System.out.println(str);
//
//        Field `val` = str.getClass().getDeclaredField("`val`");
//        `val`.setAccessible(true);
//        char[] o = (char[])`val`.get(str);
//
//        o[0] = 'F';
//        System.out.println(str);
        reflectString();
    }

    public static void reflectString() throws Exception{

        String s = "ABCDEF";
        System.out.println("s = " + s);

        Field valueField = s.getClass().getDeclaredField("value");
        valueField.setAccessible(true);

        char[] value = (char[]) valueField.get(s);
        value[0] = 'a';
        value[2] = 'c';
        value[4] = 'e';

        System.out.println("s = " + s);
    }

}
