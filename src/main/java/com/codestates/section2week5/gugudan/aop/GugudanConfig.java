package com.codestates.section2week5.gugudan.aop;

import com.codestates.section2week5.gugudan.bizlogic.Gugudan;
import com.codestates.section2week5.gugudan.bizlogic.GugudanByForLoop;
import com.codestates.section2week5.gugudan.bizlogic.GugudanByRecursion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 2023.6.14(수) 8h10
@Configuration
@EnableAspectJAutoProxy // @Aspect 애너테이션 붙인 클래스/Bean 객체의 pointcut 및 advice 설정을 사용하여 공통 기능으로 적용
public class GugudanConfig {
    @Bean
    public GugudanAspect gugudanAspect() {
        return new GugudanAspect();
    }

    @Bean
    public Gugudan gugudan() {
//        return new GugudanByForLoop();
        return new GugudanByRecursion();
    }
}
