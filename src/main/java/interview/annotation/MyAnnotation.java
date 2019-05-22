package interview.annotation;

import java.lang.annotation.*;

@Target({
        ElementType.TYPE,
        ElementType.TYPE_USE
})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    int value() default 1111;
}
