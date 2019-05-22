package dynamicbinding;

public class DynamicBinding {
    static final Super sup = new Super();
    static final Super sub = new Sub();
    static final Super sub1 = new Sub1();
    public static void main(String[] args) {
        Executor executor = new Executor();

//        Super sup = new Super();
//        Super sub = new Sub();
//        Super sub1 = new Sub1();
//
//        // Override 动态绑定
//        executor.exectorOverride(sup);
//        executor.exectorOverride(sub);
//        executor.exectorOverride(sub1);



        // Override 动态绑定
        executor.exectorOverride(sup);
        executor.exectorOverride(sub);
        executor.exectorOverride(sub1);

        // Overload 静态绑定
        executor.execte(sup);
        executor.execte(sub);
        executor.execte(sub1);
    }

    static class Super {
        public void method() {
            System.out.println("Super");
        }
    }

    static class Sub extends Super {
        @Override
        public void method() {
            System.out.println("Sub");
        }
    }


    static class Sub1 extends Super {
        @Override
        public void method() {
            System.out.println("Sub1");
        }
    }

    static class Executor {
        void execte(Super sup) {
            System.out.println("Sup");
        }

        void execte(Sub sub) {
            System.out.println("sub");
        }

        void execte(Sub1 sub) {
            System.out.println("sub1");
        }

        void exectorOverride(Super sup) {
            sup.method();
        }
    }

}
