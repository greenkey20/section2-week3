package com.codestates.section2week5.gugudan;

// 2023.6.12(월) 0h55
public class GugudanByForLoop implements Gugudan {
    @Override
    public void calculate(int level, int number) {
        for (int count = number; count < 10; count++) {
            System.out.printf("%d X %d = %d\n", level, count, level * count);
        }
    }
}
