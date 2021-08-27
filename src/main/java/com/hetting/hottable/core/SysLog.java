package com.hetting.hottable.core;


import java.lang.annotation.*;


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SysLog {

    String operation() default "";

    String type() default "";
}
