package com.codestates.section2week4.sandwichprincess.discount.policy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// 2023.5.16(화) 0h15
@Component
//@Qualifier("fixedRate")
@Primary // 빈번하게 사용되는 인스턴스는 @Primary 지정 vs 상대적으로 사용 빈도가 적은 인스턴스는 @Qualifier로 지정
public class FixedRateDiscountPolicy implements DiscountPolicy {
    private double discountRate = 10.0;

    // 2023.6.12(월) 0h5
    public FixedRateDiscountPolicy() {
    }

    public FixedRateDiscountPolicy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public int calculateDiscountedPrice(int price) {
        return (int) (price * (1 - discountRate / 100));
    }
}
