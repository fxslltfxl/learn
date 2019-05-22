package dynamicbinding;

public class DifferenceOfSatticAndFinal {
    static class Super {
        public Super() {
            testOne();
        }

        static  void sta() {
            System.out.println("Superstatic");
        }

        final void finalMethod() {
            System.out.println("final");
        }


        void testOne() {
            System.out.println("SuperTestOne");
        }

        void testSecond() {

        }
    }


    static class Sub extends Super {

        static void sta(){
            System.out.println("Substatic");
        }

        void test() {

        }

        @Override
        void testOne() {
            System.out.println("SubTestOne");
        }

    }
    static final Super sub1 = new Sub();
    public static void main(String[] args){
//        Super sub = new Sub();
//        sub.testOne();
//        sub1.testOne();
//        sub1.finalMethod();
//        sub1.sta();

        // TODO 为什么会调用子类的方法？
        Super sup = new Super();
        System.out.println("-----------");
        Super sub  = new Sub();
        System.out.println("-----------");


    }
}
