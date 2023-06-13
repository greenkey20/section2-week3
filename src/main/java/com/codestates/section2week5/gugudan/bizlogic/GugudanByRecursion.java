package com.codestates.section2week5.gugudan.bizlogic;

// 2023.6.12(월) 1h
public class GugudanByRecursion implements Gugudan {
    @Override
    public void calculate(int level, int count) {
        // 2023.6.13(화) 23h30 실행 시간 측정 추가
//        long start = System.nanoTime(); // 시작 시간

        // 문제를 더 이상 쪼갤 수 없을 때
        if (count > 9) {
            return;
        }

        // 문제를 더 작은 단위로 쪼갤 수 있을 때
        System.out.printf("%d X %d = %d\n", level, count, level * count);
        calculate(level, ++count);

        // 2023.6.13(화) 23h30 나의 질문 = 재귀 호출 시 아래 부분 여러 번 출력되는 과정 정확히 이해 못 함, debugging해보니 2*9까지 출력한 다음, count가 9~1이 되며 시간 측정/계산이 되는 것 같은데..
//        long end = System.nanoTime(); // 종료 시간
//        Utils.printLine();
//        System.out.printf("재귀 구구단(%d단) 실행 시간 = %d ns\n", level, end - start);
    }
}
