package com.codestates.section2week4.sandwichprincess.discount.condition;

import com.codestates.section2week4.sandwichprincess.discount.policy.DiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

// 2023.5.16(화) 0h30
@Component
public class YouthDiscountCondition implements DiscountCondition {
    private boolean isSatisfied;
    //    private FixedAmountDiscountPolicy fixedAmountDiscountPolicy = new FixedAmountDiscountPolicy(500); // 직접 객체 생성해서 사용 = 직접적으로 의존
    // 2023.6.11(일) 23h30
    @Autowired
    private DiscountPolicy fixedAmountDiscountPolicy;

//    public YouthDiscountCondition(DiscountPolicy discountPolicy) {
//        this.fixedAmountDiscountPolicy = discountPolicy;
//    }

    @Override
    public boolean isSatisfied() {
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    @Override
    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("나이가 어떻게 되십니까? > ");
        int input = Integer.parseInt(scanner.nextLine());
        setSatisfied(input < 20);
    }

    @Override
    public int applyDiscount(int price) {
        return fixedAmountDiscountPolicy.calculateDiscountedPrice(price);
    }
}
