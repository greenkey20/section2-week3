package com.codestates.section2week3.singleton;

import com.codestates.section2week4.sandwichprincess.product.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 2023.6.7(수) 23h
public class WithoutSingletonTest {

    @Test
    void runWithoutSingleton() {
        // given
        TestConfig testConfig = new TestConfig();

        // when
        ProductRepository productRepository1 = testConfig.productRepository();
        ProductRepository productRepository2 = testConfig.productRepository();

        // then
        assertThat(productRepository1).isNotSameAs(productRepository2);

        // 학습 시 눈으로 직접 한 번 확인해보기 위한 용도
        System.out.println("productRepository1 = " + productRepository1); // @69ee81fc
        System.out.println("productRepository2 = " + productRepository2); // @2fb0623e
    }

    // 테스트를 위한 TestConfig 클래스
    class TestConfig {
        public ProductRepository productRepository() {
            return new ProductRepository();
        }
    }
}
