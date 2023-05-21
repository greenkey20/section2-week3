package com.codestates.section2week4.sandwichprincess.discount.policy;

// 2023.5.16(화) 0h20
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
