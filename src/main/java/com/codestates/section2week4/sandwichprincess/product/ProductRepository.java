package com.codestates.section2week4.sandwichprincess.product;

import com.codestates.section2week4.sandwichprincess.product.subproduct.Drink;
import com.codestates.section2week4.sandwichprincess.product.subproduct.Sandwich;
import com.codestates.section2week4.sandwichprincess.product.subproduct.Side;
import org.springframework.stereotype.Component;

// 2023.5.11(목) 23h
@Component
public class ProductRepository {
    private final Product[] PRODUCTS = {
            new Sandwich(1, "야채 샌드위치", 3500, 300, false, 4500),
            new Sandwich(2, "에그마요 샌드위치", 4000, 450, false, 5000),
            new Side(3, "감자튀김", 1000, 300, 1),
            new Side(4, "어니언링", 1000, 200, 0),
            new Drink(5, "제로콜라", 1000, 0, false),
            new Drink(6, "스프라이트", 1000, 150, false)
    };

    public Product[] getAllProducts() {
        return PRODUCTS;
    }

    // 객체의 세부적인/내부 동작을 객체 내부로 감춤 = 캡슐화-> 객체 간 결합도(coupling) 낮춤 = 객체지향적 설계 = 변화/확장에 유연
    public Product findById(int productId) {
        for (Product product : PRODUCTS) {
            if (product.getId() == productId) {
                return product;
            }
        }

        // 주문자가 입력한 productId가 없는 번호인 경우, null 반환
        return null;
    }
}
