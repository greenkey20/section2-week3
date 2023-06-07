package com.codestates.section2week4.sandwichprincess.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 2023.6.7(수) 23h45

/**
 * 생성자로 받은 url 주소를 연결
 */
public class TestClient implements InitializingBean, DisposableBean {
    private String url;

    public TestClient(String url) {
        System.out.println("TestClient 생성자 호출");
        this.url = url;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("초기화 메서드 실행");
    }

    public void connect() {
        System.out.println("클라이언트를 " + url + "로 연결");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("종료 메서드 실행");
    }
}
