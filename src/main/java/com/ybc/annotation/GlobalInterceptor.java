package com.ybc.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
//生命周期
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping

public @interface GlobalInterceptor {
    //是否需要登录
    boolean checkLogin()default false;
    //校验参数
    boolean checkParams() default false;
    //校验管理员
    boolean checkAdmin() default false;

}
