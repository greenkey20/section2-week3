package com.codestates.section2week4.sandwichprincess.product.subproduct;

import com.codestates.section2week4.sandwichprincess.product.Product;

// 2023.5.11(목) 22h45
public class Side extends Product {
    private int ketchup;

    public Side(long id, String name, int price, int kcal, int ketchup) {
        super(id, name, price, kcal);
        this.ketchup = ketchup;
    }

    // 2023.5.15(월) 1h15 '복사 생성자' 추가 -> 객체의 깊은 복사
    public Side(Side side) {
        super(side.getName(), side.getPrice(), side.getKcal());
        this.ketchup = side.getKetchup();
    }

    public int getKetchup() {
        return ketchup;
    }

    public void setKetchup(int ketchup) {
        this.ketchup = ketchup;
    }
}
