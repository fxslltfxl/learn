package charset;

public class 转义字符 {
    public static void main(String[] args) {
        String[] clientHosts;
        String clientHost = "192.168.\\.0.1";
        String rex = "\\u002E";
        String rex1 = "\\\u002E";
        String rex2 = "\\\\u002E";
        String rex8 = "\\\\\u002E";
        String rex3 = "\\\\\\\u002E";

        String rex4 = "\\.";
        String rex6 = "\\\\.";
        String rex7 = "\\\\\\.";


        clientHosts = clientHost.split(rex8);
        System.out.println(clientHosts.length);

        float a = (float) 0.3;
        System.out.println(a);
        System.out.println(rex);
        System.out.println(rex1);
        System.out.println(rex2);
        System.out.println(rex3);
        System.out.println(rex4);
        System.out.println(rex6);
        System.out.println(rex7);


        String str2 = "a.b\\.c";
        String strs[] = str2.split("\\\\.");
        for (String str : strs) {
            System.out.println(str);
        }


    }
}
