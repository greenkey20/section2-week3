package com.codestates.section2week3.scope.singleton;

import com.codestates.section2week4.sandwichprincess.common.TestConfigurer;
import com.codestates.section2week4.sandwichprincess.product.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

// 2023.6.7(수) 23h15
public class AppConfigurerSingletonTest {

    /**
     * Spring 컨테이너는 내부적으로 객체들을 Singleton으로 관리 = Singleton registry <- Spring은 CGLIB라는 바이트코드 조작 라이브러리 사용
     */
    @Test
    @DisplayName("AppConfigurer 싱글턴 패턴 테스트")
    void runWithSingletonInAppConfigurer() {
        // given
        // Spring 컨테이너 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfigurer.class);

        // when
        ProductRepository productRepository1 = applicationContext.getBean("productRepository", ProductRepository.class);
        ProductRepository productRepository2 = applicationContext.getBean("productRepository", ProductRepository.class);

        // then
        assertThat(productRepository1).isSameAs(productRepository2);

        // 학습 시 눈으로 직접 한 번 확인해보기 위한 용도
        System.out.println("productRepository1 = " + productRepository1); // @62679465
        System.out.println("productRepository2 = " + productRepository2); // @62679465
    }
}
