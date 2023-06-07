package com.codestates.section2week4.sandwichprincess.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 2023.6.7(수) 23h45

/**
 * 생성자로 받은 url 주소를 연결
 */
public class TestClient /*implements InitializingBean, DisposableBean*/ {
    private String url;

    public TestClient(String url) {
        System.out.println("TestClient 생성자 호출");
        this.url = url;
    }

    /**
     * Spring 컨테이너 초기화 과정에허 호출되는 메서드
     *
     * @throws Exception
     */
    // 방법1)
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("초기화 메서드 실행");
//    }

    // 2023.6.8(목) 0h5 방법2)
    @PostConstruct // 2023.6.8(목) 0h10 방법3) 최신 Spring에서 가장 권장
    public void init() {
        System.out.println("초기화 메서드 init() 실행");
    }


    public void connect() {
        System.out.println("클라이언트를 " + url + "로 연결");
    }

    /**
     * Spring 컨테이너 종료 시 호출되는 메서드
     *
     * @throws Exception
     */
    // 방법1)
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("종료 메서드 실행");
//    }
    // 2023.6.8(목) 0h5 방법2)
    @PreDestroy // 2023.6.8(목) 0h10 방법3) 최신 Spring에서 가장 권장
    public void close() {
        System.out.println("종료 메서드 close() 실행");
    }
}
