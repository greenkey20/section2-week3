package com.codestates.section2week4.sandwichprincess.discount.policy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 2023.5.16(화) 0h20
@Component
@Qualifier("fixedAmount")
public class FixedAmountDiscountPolicy implements DiscountPolicy {
    private int discountAmount;

    // 2023.6.12(월) 0h5
    public FixedAmountDiscountPolicy() {
    }

    public FixedAmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public int calculateDiscountedPrice(int price) {
        return price - discountAmount;
    }
}
