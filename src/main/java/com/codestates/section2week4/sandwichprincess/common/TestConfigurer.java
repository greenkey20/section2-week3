package com.codestates.section2week4.sandwichprincess.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 2023.6.10(토) 17h
@Configuration
@ComponentScan(basePackages = "com.codestates.section2week4.sandwichprincess") // 별다른 설정 없는 경우 이 애너테이션이 붙은 구성 정보 클래스 패키지 = 스캔의 시작 위치
public class TestConfigurer {

}
