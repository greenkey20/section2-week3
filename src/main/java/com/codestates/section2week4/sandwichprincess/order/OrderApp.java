package com.codestates.section2week4.sandwichprincess.order;

import com.codestates.section2week4.sandwichprincess.product.Menu;
import com.codestates.section2week4.sandwichprincess.product.ProductRepository;

import java.util.Scanner;

// 2023.5.11(목) 23h10
public class OrderApp {
    private ProductRepository productRepository;
    private Menu menu;
    private Cart cart;
    private Order order;

    // AppConfigurer가 생성한 객체를 주입받아서 사용
    public OrderApp(ProductRepository productRepository, Menu menu, Cart cart, Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }

    public void view() {
        Scanner scanner = new Scanner(System.in);

        /*
        ProductRepository productRepository = new ProductRepository(); // 필요한 객체 생성1
        Product[] PRODUCTS = productRepository.getAllProducts();
        Menu menu = new Menu(PRODUCTS); // 필요한 객체 생성2

        // 2023.5.15(월) 0h5
        Cart cart = new Cart(productRepository, menu); // 필요한 객체 생성3

        // 2023.5.16(화) 0h5
        // 필요한 객체 생성4
        Order order = new Order(cart, new Discount(
                new DiscountCondition[]{
                        new StudentDiscountCondition(new FixedRateDiscountPolicy(10.0)),
                        new YouthDiscountCondition(new FixedAmountDiscountPolicy(500))
                }));
        */

        System.out.println("== 🥪 SandwichPrincess order service ==");

        while (true) {
            // 메뉴 출력
            menu.printMenu();

            // 사용자 입력받기
            String input = scanner.nextLine();

            if (input.equals("+")) {
                // 주문 내역 출력
                order.placeOrder();
                break;
            } else if (input.equals("0")) {
                // 장바구니 출력
                cart.printCart();
            } else { // 사용자 입력 == 1 ~ 메뉴 마지막 번호
                int productIdChosen = Integer.parseInt(input);
                // 사용자가 고른 상품의 옵션 보여주고 고르게 함 = menu.chooseOption() = addToCart() 안에서 호출됨
                // 장바구니에 담기
                cart.addToCart(productIdChosen);
            }
        }
    }
}
