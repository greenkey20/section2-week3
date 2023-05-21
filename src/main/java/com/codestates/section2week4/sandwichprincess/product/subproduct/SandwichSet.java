package com.codestates.section2week4.sandwichprincess.product.subproduct;

import com.codestates.section2week4.sandwichprincess.product.Product;

// 2023.5.11(목) 22h50
public class SandwichSet extends Product {
    // 멤버변수
    private Sandwich sandwich;
    private Side side;
    private Drink drink;

    // 생성자 -> 2023.5.14(일) 11h45 composeSet() 메서드 작성하며 수정
    public SandwichSet(String name, int price, int kcal, Sandwich sandwich, Side side, Drink drink) {
        super(name, price, kcal);
        this.sandwich = sandwich;
        this.side = side;
        this.drink = drink;
    }

    // g/setter
    // 세트 구성 시 생성자를 통해서 할 것인 바, setter는 만들지 않아도 됨
    public Sandwich getSandwich() {
        return sandwich;
    }

    public Side getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }
}

