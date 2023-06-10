package com.codestates.section2week4.sandwichprincess.product;

import com.codestates.section2week4.sandwichprincess.product.subproduct.Drink;
import com.codestates.section2week4.sandwichprincess.product.subproduct.Sandwich;
import com.codestates.section2week4.sandwichprincess.product.subproduct.Side;
import org.springframework.stereotype.Component;

import static com.codestates.section2week4.sandwichprincess.common.Utils.printLine;

// 2023.5.11(목) 23h20
@Component
public class Menu {
    private Product[] PRODUCTS;

    public Menu(ProductRepository products) {
        this.PRODUCTS = products.getAllProducts();
    }

    // 2023.5.12(금) 21h45

    /**
     * 전체 메뉴 출력
     */
    public void printMenu() {
        printLine();
        System.out.println("[메뉴]");
        System.out.println();

        // 샌드위치 출력
        printSandwiches(false); // refactoring > extract method

        // 사이드 출력
        printSides(false);

        // 음료 출력
        printDrinks(false);

        printLine();

        System.out.println("[0] 장바구니");
        System.out.println("[+] 주문하기");
        printLine();

        System.out.print("메뉴를 선택해 주세요 > ");
    }

    // 2023.5.14(일) 11h50 composeSet() 메서드 작성하며 수정
    private void printSandwiches(boolean isSet) {
        System.out.println("- 샌드위치");

        for (Product product : PRODUCTS) {
            if (product instanceof Sandwich) {
                printEachMenu(product, isSet);
            }
        }

        System.out.println();
    }

    // 2023.5.14(일) 11h50 composeSet() 메서드 작성하며 수정
    public void printSides(boolean isSet) {
        if (!isSet) {
            System.out.println("- 사이드");
        }

        for (Product product : PRODUCTS) {
            if (product instanceof Side) {
                printEachMenu(product, isSet);
            }
        }

        System.out.println();
    }

    // 2023.5.14(일) 11h50 composeSet() 메서드 작성하며 수정
    public void printDrinks(boolean isSet) {
        if (!isSet) {
            System.out.println("- 음료");
        }

        for (Product product : PRODUCTS) {
            if (product instanceof Drink) {
                printEachMenu(product, isSet);
            }
        }

        System.out.println();
    }

    // 2023.5.14(일) 11h45 composeSet() 메서드 작성하며 수정
    private static void printEachMenu(Product product, boolean isSet) {
        if (!isSet) {
            System.out.printf("[%d] %s %5dKcal %5d원\n", product.getId(), product.getName(), product.getKcal(), product.getPrice());
        } else {
            System.out.printf("[%d] %s %5dKcal\n", product.getId(), product.getName(), product.getKcal());
        }
    }
}
