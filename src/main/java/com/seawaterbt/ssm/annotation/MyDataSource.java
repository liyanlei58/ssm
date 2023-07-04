package com.seawaterbt.ssm.annotation;

import com.seawaterbt.ssm.enums.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义多数据源切换
 * @author zzh
 * @date 2023/4/28 15:19:21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyDataSource {
    DataSourceEnum value() default DataSourceEnum.DB1;
}
