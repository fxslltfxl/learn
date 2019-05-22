package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaThis implements TestInterface1, TestInterface2 {

    private static List<String> list = new ArrayList<>();

    public void lambda() {
        System.out.println(this.toString());
        new Thread(() -> System.out.println(this.toString())).start();
    }

    public static void main(String[] a) {
        LambdaThis lambdaThis = new LambdaThis();
        lambdaThis.lambda();
        //lambda 表达式中的this 调用的是创建lambda表达式的方法中的this，所以三个输出相同
        System.out.println(lambdaThis.toString());

        TestInterface1 lambdaThis1 = lambdaThis;
        list.sort(Comparator.comparing(String::length));
    }

    @Override
    public void test1() {
        LocalDate localDate=LocalDate.now();
    }

    @Override
    public void test2() {
    }
}
