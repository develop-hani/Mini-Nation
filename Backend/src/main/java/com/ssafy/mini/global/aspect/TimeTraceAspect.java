package com.ssafy.mini.global.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class TimeTraceAspect {

    @Around("execution(* com.ssafy.mini.domain.*.controller..*(..))")
    public Object executionAspect(ProceedingJoinPoint joinPoint) throws Throwable
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();
        log.info("{} ms 소요", stopWatch.getTotalTimeMillis());

        return result;
    }

}
