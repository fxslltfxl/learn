package interview.annotation;

import org.jetbrains.annotations.NotNull;

@MyAnnotation
public class MyAnnotationClass<@MyAnnotation T> {
    public static void main(@NotNull String[] args) {
        MyAnnotationClass my = new MyAnnotationClass();
        MyAnnotation annotation = my.getClass().getAnnotation(MyAnnotation.class);
        @MyAnnotation int value = annotation.value();
    }
}
