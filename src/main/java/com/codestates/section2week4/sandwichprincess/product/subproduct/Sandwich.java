package com.codestates.section2week4.sandwichprincess.product.subproduct;

import com.codestates.section2week4.sandwichprincess.product.Product;

// 2023.5.11(목) 22h40
public class Sandwich extends Product {
    private boolean isSandwichSet;
    private int sandwichSetPrice;

    public Sandwich(long id, String name, int price, int kcal, boolean isSandwichSet, int sandwichSetPrice) {
        super(id, name, price, kcal);
        this.isSandwichSet = isSandwichSet;
        this.sandwichSetPrice = sandwichSetPrice;
    }

    // 2023.5.15(월) 1h15 '복사 생성자' 추가 -> 객체의 깊은 복사
    public Sandwich(Sandwich sandwich) {
        super(sandwich.getName(), sandwich.getPrice(), sandwich.getKcal());
        this.isSandwichSet = sandwich.isSandwichSet();
        this.sandwichSetPrice = sandwich.getSandwichSetPrice();
    }

    public boolean isSandwichSet() {
        return isSandwichSet;
    }

    public void setSandwichSet(boolean isSandwichSet) {
        this.isSandwichSet = isSandwichSet;
    }

    public int getSandwichSetPrice() {
        return sandwichSetPrice;
    }

    public void setSandwichSetPrice(int sandwichSetPrice) {
        this.sandwichSetPrice = sandwichSetPrice;
    }
}
