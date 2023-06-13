package com.codestates.section2week5.gugudan.bizlogic;

// 2023.6.12(월) 0h55
public class GugudanByForLoop implements Gugudan {
    @Override
    public void calculate(int level, int number) {
        // 2023.6.13(화) 23h20 실행 시간 측정 추가
//        long start = System.nanoTime(); // 시작 시간

        for (int count = number; count < 10; count++) {
            System.out.printf("%d X %d = %d\n", level, count, level * count);
        }

//        long end = System.nanoTime(); // 종료 시간
//        Utils.printLine(); // 나의 질문 = 다른 패키지에 있는 Utils 클래스의 객체 생성 없이 이렇게 사용할 수 있는 이유는?
//        System.out.printf("for문 구구단(%d단) 실행 시간 = %d ns\n", level, end - start);
    }
}
