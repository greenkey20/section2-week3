package com.codestates.section2week4.sandwichprincess.discount.condition;

import com.codestates.section2week4.sandwichprincess.discount.policy.DiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

// 2023.5.16(화) 0h25
@Component
public class StudentDiscountCondition implements DiscountCondition {
    private boolean isSatisfied;
    //    private FixedRateDiscountPolicy fixedRateDiscountPolicy = new FixedRateDiscountPolicy(10.0); // 직접 객체 생성해서 사용 = 직접적으로 의존 = 특정 객체가 어떤 객체를 사용할지 직접 결정 + 특정 역할(x) 그 역할 수행하는 구체적 클래스/구현(o)에 의존 -> 필연적인 변화 수용 시 부수적으로 변경해야 할 코드 많음 = 문제점
    // 2023.6.11(일) 23h30
    @Autowired
    private DiscountPolicy fixedRateDiscountPolicy; // 직접 객체 생성x = 어떤 객체 사용할지 직접 결정x = 특정 필요한 역할을 수행하는 객체를 생성자를 통해 외부로부터 주입받아 사용 = 역할에 의존 = 인터페이스에 의존 = 구체적인 구현 객체는 자유롭게 교체될 수 있음 -> oop는 변화와 확장에 유연

    // 생성자 주입을 통한 의존성 주입
//    public StudentDiscountCondition(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
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
        System.out.print("학생입니까? [1] 예 [2] 아니오 > ");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            setSatisfied(true);
        } else if (input.equals("2")) { // 굳이 2일 때 처리해줘야 하나?
            setSatisfied(false);
        }
    }

    @Override
    public int applyDiscount(int price) {
        return fixedRateDiscountPolicy.calculateDiscountedPrice(price);
    }
}
