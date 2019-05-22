package interview;

public class Sub extends Sup {

    public static String name = "xww";

    public String normalName;

    public Sub() {
        this.normalName = "xww";
    }

    public static void method() {
        System.out.println("sub static method");
    }

    public void normalMethod() {
        System.out.println("sub method");
    }

    static class Inner {
        private String des = "DES";
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException
            , ClassNotFoundException {
        //region 这种写法除了Override 方法会走子类方法，static和non-static field 以及 static method 均为父类隐藏子类实现。
        Sup sub = new Sub();
        Inner inner = new Inner();
        String des = inner.des;
        System.out.println(sub.normalName);
        System.out.println(sub.name);
        sub.normalMethod();
        sub.method();
        //endregion

        //region 下一次

        //endregion

    }

}
