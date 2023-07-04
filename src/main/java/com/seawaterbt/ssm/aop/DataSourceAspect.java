package com.seawaterbt.ssm.aop;

import com.seawaterbt.ssm.annotation.MyDataSource;
import com.seawaterbt.ssm.multiple.DynamicDataSourceContextHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@annotation(com.seawaterbt.ssm.annotation.MyDataSource)"
            + "|| @within(com.seawaterbt.ssm.annotation.MyDataSource)")
    public void dsPc() {

    }

    @Before("dsPc()  && @annotation(myDataSource)")
    public void doBefore(MyDataSource myDataSource)  {
        DynamicDataSourceContextHolder.setDataSourceType(myDataSource.value().getValue());
    }

    @After("dsPc()")
    public void doAfter() {
        DynamicDataSourceContextHolder.clearDataSourceType();
    }

}
