package com.codestates.section2week4.sandwichprincess.discount;

import com.codestates.section2week4.sandwichprincess.discount.condition.DiscountCondition;
import com.codestates.section2week4.sandwichprincess.discount.condition.StudentDiscountCondition;
import com.codestates.section2week4.sandwichprincess.discount.condition.YouthDiscountCondition;
import com.codestates.section2week4.sandwichprincess.discount.policy.FixedAmountDiscountPolicy;
import com.codestates.section2week4.sandwichprincess.discount.policy.FixedRateDiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 2023.5.16(화) 10h50 객체의 자율성 높이기
@Component // 이 어노테이션이 붙은 클래스들은 ComponentScan에 의해 스캔됨 -> 자동으로 Spring 컨테이너가 이 클래스의 인스턴스를 생성해서 Spring Bean으로 등록/관리
public class Discount {
    private DiscountCondition[] discountConditions;

    // 2023.6.10(토) 19h AppConfigurer에서의 구현 내용처럼 새로운 생성자 추가
    @Autowired
    public Discount() {
        this.discountConditions = new DiscountCondition[]{
                new StudentDiscountCondition(new FixedRateDiscountPolicy(10.0)),
                new YouthDiscountCondition(new FixedAmountDiscountPolicy(500))
        };
    }

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

    // 2023.6.10(토) 19h5 추가
    public void checkAllDiscount() {
        for (DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
        }
    }
}
