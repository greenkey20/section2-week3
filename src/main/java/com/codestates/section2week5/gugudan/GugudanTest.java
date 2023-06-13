package com.codestates.section2week5.gugudan;

import com.codestates.section2week4.sandwichprincess.common.Utils;

// 2023.6.13(화) 23h25
public class GugudanTest {
    public static void main(String[] args) {
        int level = 2;
        int count = 1;

        // for문 구구단
        GugudanByForLoop gugudanByForLoop = new GugudanByForLoop();
        GugudanProxy proxy = new GugudanProxy(gugudanByForLoop);
        proxy.calculate(level, count);

        // 재귀 구구단
        GugudanByRecursion gugudanByRecursion = new GugudanByRecursion();
        GugudanProxy proxy2 = new GugudanProxy(gugudanByRecursion);
        proxy2.calculate(level, count);
    }
}
