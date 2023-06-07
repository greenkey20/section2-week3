package com.codestates.section2week4.sandwichprincess.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 2023.6.7(수) 23h50

/**
 * Bean 구성 정보 클래스
 */
@Configuration
public class ClientConfig {

    // Spring 컨테이너에 TestClient Bean 객체를 수동으로 등록
    @Bean
    public TestClient testClient() {
        TestClient testClient = new TestClient("www.swprincess.com");
        return testClient;
    }
}
