package com.codestates.section2week4.sandwichprincess.discount.policy;

import org.springframework.stereotype.Component;

// 2023.5.16(화) 0h15
@Component
public class FixedRateDiscountPolicy implements DiscountPolicy {
    private double discountRate;

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
