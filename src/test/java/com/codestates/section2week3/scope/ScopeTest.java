package com.codestates.section2week3.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

// 2023.6.10(토) 16h30
public class ScopeTest {

    @Test
    public void scopeTest() {
        //given
        // Spring 컨테이너 생성
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBean.class);

        // when
        // 컨테이너 사용
        // Bean 객체의 관리 범위를 Singleton이 아닌 prototype으로 변경해서 실행하면, 각기 다른 Bean이 조회됨
        TestBean bean1 = applicationContext.getBean(TestBean.class);
        TestBean bean2 = applicationContext.getBean(TestBean.class);

        // then
        System.out.println("bean1 = " + bean1); // Singleton scope일 때 @278bb07e vs prototype scope일 때 @4c550889
        System.out.println("bean2 = " + bean2); // Singleton scope일 때 @278bb07e vs prototype scope일 때 @1d2bd371

        assertThat(bean1).isNotSameAs(bean2);

        // 컨테이너 종료
        // prototype scope일 때 종료 메서드는 호출되지 않음 <- Bean 생성, 의존성 주입, 초기화까지만 Spring 컨테이너가 관여
        applicationContext.close();
    }

    @Scope("prototype") // 이 클래스의 인스턴스의 관리 범위 = prototype
    static class TestBean {
        // 초기화 메서드
        @PostConstruct
        public void init() {
            System.out.println("초기화 메서드 init() 실행");
        }

        // 종료 메서드
        @PreDestroy
        public void close() {
            System.out.println("종료 메서드 close() 실행");
        }
    }
}
