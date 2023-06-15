package com.codestates.section2week5.gugudan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2023.6.15(목) 12h30
@Aspect
//@Order(value = 2)
public class GugudanCacheAspect {
    // 캐시 저장소
    private List<Object> cache = new ArrayList<>();

    // pointcut 적용
    @Pointcut("execution(* cal*(..))")
    public void cacheTargetMethod() {

    }

    // advice 정의
    // 현재 advice 적용 순서 = CacheAspect -> MeasureTimeAspect -> GugudanByRecursion
    // 나의 질문 = 왜/어떻게 CacheAspect 프록시 객체의 target 객체가 MeasureTimeAspect인 거지?
    @Around("cacheTargetMethod()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        // 데이터 초기화
        Object[] argumentObject = joinPoint.getArgs();
        String argumentToString = Arrays.toString(argumentObject);

        // 캐시에 데이터가 있다면, 캐시에서 꺼내서 반환/전달
        if (cache.size() != 0) {
            for (Object element : cache) {
                String elementToString = Arrays.toString((Object[]) element);

                if (elementToString.equals(argumentToString)) {
                    System.out.printf("cache에서 데이터 불러오기 [%s]\n", elementToString);
                    return elementToString;
                }
            }
        }

        // 캐시에 데이터가 없다면, target 객체의 메서드를 호출해서 캐시에 데이터 추가
        Object result = joinPoint.proceed();
        cache.add(argumentObject);
        System.out.printf("cache에 데이터 추가 [%s]\n", Arrays.toString(argumentObject));
        return result;
    }


}
