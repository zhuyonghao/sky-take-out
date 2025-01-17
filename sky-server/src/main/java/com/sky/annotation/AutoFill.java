package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于标识某个方法需要进行功能字段自动填充处理
 */
@Target(ElementType.METHOD)             // 可以应用的位置
@Retention(RetentionPolicy.RUNTIME)     // 注解的保留时间，注解在运行时仍然可用，允许通过反射访问
public @interface AutoFill {
    // 数据库操作类型：UPDATE INSERT
    // OperationType自定义的一个枚举类
    OperationType value();              // 注解的一个元素
}
