package _10枚举类;/* 2020/8/28 17:04 */

import org.junit.Test;

import java.lang.annotation.*;
import java.util.*; //import java.io.*;

import static java.lang.annotation.ElementType.*;

/*
MyAnnotations ?? 没搞明白
 */
@Inherited
//@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    //该注解有一个名为value的可选参数
    String value() default "hello";
}