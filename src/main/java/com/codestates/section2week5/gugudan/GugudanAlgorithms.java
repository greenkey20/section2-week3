package com.codestates.section2week5.gugudan;

// 2023.6.12(월) 0h50
public class GugudanAlgorithms {
    public void gugudanByForLoop(int level) {
        for (int count = 1; count < 10; count++) {
            System.out.printf("%d X %d = %d\n", level, count, level * count);
        }
    }

    public void gugudanByRecursion(int level, int count) {
        // 문제를 더 이상 쪼갤 수 없을 때
        if (count > 9) {
            return;
        }

        // 문제를 더 작은 단위로 쪼갤 수 있을 때
        System.out.printf("%d X %d = %d\n", level, count, level * count);
        gugudanByRecursion(level, ++count);
    }
}