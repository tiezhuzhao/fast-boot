package com.ttsh.mc.config.Aspect;
import java.lang.annotation.*;

/**
 * @author zhaozhe
 * 2019-7-26 18:36:06
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
     String description() default "";
}