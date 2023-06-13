package com.codestates.section2week5.gugudan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 2023.6.14(수) 0h25
@Aspect
public class GugudanAspect {

    //    @Pointcut("execution(public void com..calculate(..))") // aspect를 적용할 위치/지점
//    @Pointcut("execution(* cal*(..))")
    @Pointcut("execution(public void cal*(..))")
    private void targetMethod() {

    }

    @Around("targetMethod()") // target 객체의 메서드 실행 전/후 또는 예외 발생 시 공통 기능 실행 -> targetMethod()에 정의한 pointcut에 공통 기능 적용
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable { // 핵심 기능의 실행 시간 측정 AOP 메서드
        long start = System.nanoTime(); // 시작 시간

        try {
            Object result = joinPoint.proceed(); // target 객체의 실제 메서드 호출
            return result;
        } finally {
            long end = System.nanoTime(); // 종료 시간
            Signature signature = joinPoint.getSignature();
            System.out.printf("%s.%s 메서드 호출\n", joinPoint.getTarget().getClass().getSimpleName(), signature.getName());
            System.out.printf("실행 시간 = %d ns\n", end - start);
        }
    }
}
