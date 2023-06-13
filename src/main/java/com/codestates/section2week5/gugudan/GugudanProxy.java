package com.codestates.section2week5.gugudan;

import com.codestates.section2week4.sandwichprincess.common.Utils;

// 2023.6.13(화) 23h50

/**
 * Proxy = 핵심 기능은 다른 객체에게 위임 + 공통적인 부가적 기능 제공 -> 코드 중복 없앰 + 핵심 로직 코드 변경 없이도 공통적 부가 기능 추가/실행 가능
 * 구구단 생성(핵심 기능)은 로직 담당 클래스들이 집중해서 담당
 */
public class GugudanProxy implements Gugudan {
    private Gugudan delegator;

    public GugudanProxy(Gugudan delegator) {
        this.delegator = delegator;
    }

    @Override
    public void calculate(int level, int count) {
        // '실행 시간 측정'이라는 부가적인 기능 정의
        System.out.printf("클래스명 = %s\n", delegator.getClass().getSimpleName());
        long start = System.nanoTime(); // 시작 시간

        // 핵심 기능 로직 및 실행은 생성자로 전달받은 객체에게 위임
        delegator.calculate(level, count);

        // '실행 시간 측정'이라는 부가적인 기능 정의(계속)
        long end = System.nanoTime(); // 종료 시간
        System.out.printf("구구단(%d단) 실행 시간 = %d ns\n", level, end - start);
        Utils.printLine();
    }
}
