package com.codestates.section2week5.gugudan;

import com.codestates.section2week4.sandwichprincess.common.Utils;

// 2023.6.13(화) 23h25
public class GugudanTest {
    public static void main(String[] args) {
        int level = 2;

        // for문 구구단
        GugudanByForLoop gugudanByForLoop = new GugudanByForLoop();
        System.out.println("==== for문 구구단 ====");
        long start1 = System.nanoTime(); // 시작 시간
        gugudanByForLoop.calculate(2, 1);

        long end1 = System.nanoTime(); // 종료 시간
        Utils.printLine();
        System.out.printf("for문 구구단(%d단) 실행 시간 = %d ns\n", level, end1 - start1);

        // 재귀 구구단
        GugudanByRecursion gugudanByRecursion = new GugudanByRecursion();
        long start2 = System.nanoTime(); // 시작 시간
        System.out.println("==== 재귀 구구단 ====");
        gugudanByRecursion.calculate(2, 1);

        long end2 = System.nanoTime(); // 종료 시간
        Utils.printLine();
        System.out.printf("재귀 구구단(%d단) 실행 시간 = %d ns\n", level, end2 - start2);
    }
}
