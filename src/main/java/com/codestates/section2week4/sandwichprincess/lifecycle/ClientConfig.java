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
    // destroyMethod 속성은 default 값이 추론되는 것 -> 라이브러리 등에서 빈번하게 사용되는 close(), shutdown() 등의 이름의 메서드를 자동으로 호출
    @Bean(initMethod = "init"/*, destroyMethod = "close"*/)
    public TestClient testClient() {
        TestClient testClient = new TestClient("www.swprincess.com");
        return testClient;
    }
}
