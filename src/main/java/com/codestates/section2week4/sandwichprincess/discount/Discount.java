package com.codestates.section2week4.sandwichprincess.discount;

import com.codestates.section2week4.sandwichprincess.discount.condition.DiscountCondition;

// 2023.5.16(화) 10h50 객체의 자율성 높이기
public class Discount {
    private DiscountCondition[] discountConditions;

    public Discount(DiscountCondition[] discountConditions) {
        this.discountConditions = discountConditions;
    }

    public int calculateFinalDiscountedPrice(int price) {
        int finalDiscountedPrice = price;

        for (DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
            if (discountCondition.isSatisfied()) {
                finalDiscountedPrice = discountCondition.applyDiscount(finalDiscountedPrice);
            }
        }

        return finalDiscountedPrice;
    }
}
