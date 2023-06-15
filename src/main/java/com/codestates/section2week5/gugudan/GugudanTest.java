package com.codestates.section2week5.gugudan;

import com.codestates.section2week5.gugudan.aop.GugudanConfig;
import com.codestates.section2week5.gugudan.aop.GugudanProxy;
import com.codestates.section2week5.gugudan.bizlogic.Gugudan;
import com.codestates.section2week5.gugudan.bizlogic.GugudanByForLoop;
import com.codestates.section2week5.gugudan.bizlogic.GugudanByRecursion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 2023.6.13(화) 23h25
public class GugudanTest {
    public static void main(String[] args) {
        int level = 2;
        int count = 1;

        // aspect 적용 전
        // for문 구구단
        /*
        GugudanByForLoop gugudanByForLoop = new GugudanByForLoop();
        GugudanProxy proxy = new GugudanProxy(gugudanByForLoop);
        proxy.calculate(level, count);

        // 재귀 구구단
        GugudanByRecursion gugudanByRecursion = new GugudanByRecursion();
        GugudanProxy proxy2 = new GugudanProxy(gugudanByRecursion);
        proxy2.calculate(level, count);
         */

        // 2023.6.14(수) 8h15 aspect 적용
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(GugudanConfig.class);

        Gugudan gugudan = applicationContext.getBean("gugudan", Gugudan.class);
        gugudan.calculate(level, count);
        // 2023.6.15(목) 12h45 동일한 방법으로 메서드 2번 더 호출
        gugudan.calculate(level, count);
        gugudan.calculate(level, count);
    }
}
