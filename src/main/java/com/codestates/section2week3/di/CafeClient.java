package com.codestates.section2week3.di;

import java.util.List;

// 2023.5.15(월) 22h35
public class CafeClient {
    public static void main(String[] args) {
        MenuService menuService = new MenuServiceStub(); // upcasting을 통한 의존성 주입 -> MenuController-MenuService 간 느슨한(loose) 결합(coupling)
        MenuController menuController = new MenuController(menuService);
        List<Menu> menuList = menuController.getMenus();
    }
}
