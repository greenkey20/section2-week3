package com.codestates.section2week4.sandwichprincess.discount.policy;

import org.springframework.stereotype.Component;

// 2023.5.16(화) 0h20
@Component
public class FixedAmountDiscountPolicy implements DiscountPolicy {
    private int discountAmount;

    public FixedAmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public int calculateDiscountedPrice(int price) {
        return price - discountAmount;
    }
}
