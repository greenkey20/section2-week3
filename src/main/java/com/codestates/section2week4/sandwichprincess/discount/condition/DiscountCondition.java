package com.codestates.section2week4.sandwichprincess.discount.condition;

// 2023.5.16(화) 1h45
public interface DiscountCondition {
    boolean isSatisfied();
    void checkDiscountCondition();
    int applyDiscount(int price);
}
