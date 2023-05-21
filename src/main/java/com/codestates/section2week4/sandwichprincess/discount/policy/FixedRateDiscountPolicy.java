package com.codestates.section2week4.sandwichprincess.discount.policy;

// 2023.5.16(화) 0h15
public class FixedRateDiscountPolicy implements DiscountPolicy {
    private double discountRate;

    public FixedRateDiscountPolicy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public int calculateDiscountedPrice(int price) {
        return (int) (price * (1 - discountRate / 100));
    }
}
