package com.codestates.section2week4.sandwichprincess.product.subproduct;

import com.codestates.section2week4.sandwichprincess.product.Product;

// 2023.5.11(목) 22h45
public class Drink extends Product {
    private boolean hasStraw;

    public Drink(long id, String name, int price, int kcal, boolean hasStraw) {
        super(id, name, price, kcal);
        this.hasStraw = hasStraw;
    }

    // 2023.5.15(월) 1h20 '복사 생성자' 추가 -> 객체의 깊은 복사
    public Drink(Drink drink) {
        super(drink.getName(), drink.getPrice(), drink.getKcal());
        this.hasStraw = drink.hasStraw();
    }

    public boolean hasStraw() { // 자동생성한 getter의 이름(isHasStraw)을 의미에 부합하게 변경
        return hasStraw;
    }

    public void setHasStraw(boolean hasStraw) {
        this.hasStraw = hasStraw;
    }
}
