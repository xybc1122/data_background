package com.dt.project.customize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName SelValue
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/6 13:57
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SelValue {
    String column() default "";

    String property() default "";


}
