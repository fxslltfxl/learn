package annotation;

public class UnsafeVarargs {
    public static <T> T[] asArray(T... args) {
        return args;
    }

    public static <T> T[] arrayOfTwo(T a, T b) {
        return asArray(a, b);
    }

    public static void main(String[] args) {
        Object[] strings = arrayOfTwo("hi", "mom");
        foo(strings);


    }
    @SafeVarargs
    static <T> void foo(T... args){
        for (T arg : args) {
            System.out.println(arg);
        }
    }

    @Subscriber("testForSubscriber")
    void testForSubscriber(){
        System.out.println(this.getClass().getSimpleName());
    }
}
