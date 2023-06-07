package com.codestates.section2week4.sandwichprincess.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 2023.6.7(수) 23h55
public class ClientMain {
    public static void main(String[] args) {
        // Spring 컨테이너 생성
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClientConfig.class);

        // 컨테이너 사용
        TestClient testClient = applicationContext.getBean("testClient", TestClient.class);
        testClient.connect();

        // 컨테이너 종료
        applicationContext.close();
    }
}
