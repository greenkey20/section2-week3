package com.codestates.section2week3.di;

import java.util.List;

// 2023.5.15(월) 22h50
public class MenuController {
    private MenuService menuService; // 인터페이스를 이용한 느슨한(loose) 결합(coupling)

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public List<Menu> getMenus() {
        return menuService.getMenuList();
    }
}
