package classload;

public class SingletonSecond {
    private SingletonSecond() {
    }

    private static class Holder {
        private static SingletonSecond INSTANCE = new SingletonSecond();

        static {
            System.out.println("test");
        }
    }

    public static Object getInstance(boolean flag) {
        if (flag) return new Holder[2];
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("------------------------");
        System.out.println("args = [" + args + "]");
        getInstance(false);
    }
}
