package com.throne.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect {
    static final Logger logger  = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Around("execution(* com.throne.service.impl..*.*(..))")
    /*
    1. * 返回类型
    2. com.throne.service.impl 需要监控的package
    3. .. 该package和子package下的所有类方法
    4. * 类名
    5  *(..) 某一类名下的方法的任何参数
     */
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(
                "======开始执行{}.{}======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName()
        );

        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info(
                "======执行结束{}.{}，耗时：{}毫秒======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName(),
                end - begin
        );
        return result;
    }
}
