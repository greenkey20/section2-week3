package com.codestates.section2week3.scope.singleton;

import com.codestates.section2week4.sandwichprincess.product.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 2023.6.7(수) 23h10
// 이 Singleton 패턴 구현의 문제점 = new 생성자를 통한, 구현 객체에 직접적으로 의존 = 객체 간 높은 결합도
public class SingletonTest {

    @Test
    void runWithSingleton() {
        // given
        TestConfig testConfig = new TestConfig();

        // when
        ProductRepository productRepository1 = testConfig.productRepository();
        ProductRepository productRepository2 = testConfig.productRepository();

        // then
        assertThat(productRepository1).isSameAs(productRepository2);

        // 학습 시 눈으로 직접 한 번 확인해보기 위한 용도
        System.out.println("productRepository1 = " + productRepository1); // @69ee81fc
        System.out.println("productRepository2 = " + productRepository2); // @69ee81fc
    }

    class TestConfig {
        // 멤버 변수
        private final ProductRepository productRepository = new ProductRepository();

        // 생성자
        private TestConfig() {

        }

        // 멤버 메서드
        public ProductRepository productRepository() {
            return productRepository;
        }
    }
}
