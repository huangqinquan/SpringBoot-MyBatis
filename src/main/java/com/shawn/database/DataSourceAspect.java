package com.shawn.database;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

//    @Pointcut("@within(com.shawn.database.DataSource) || @annotation(com.shawn.database.DataSource)")
//    @Pointcut("@annotation(dataSource)")
//    public void pointCut(){
//
//    }

//    @Before("pointCut() && @annotation(dataSource)")
    @Before("@annotation(dataSource)")
    public void doBefore(JoinPoint point, DataSource dataSource){
        log.info("选择数据源---"+dataSource.value());
        DataSourceContextHolder.setDataSource(dataSource.value());
    }

//    @After("pointCut()")
    @After("@annotation(dataSource)")
    public void doAfter(JoinPoint point, DataSource dataSource){
        DataSourceContextHolder.clear();
    }
}
