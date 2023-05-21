package com.codestates.section2week3.di;

import java.util.List;

// 2023.5.15(월) 22h45
public class MenuServiceStub implements MenuService {
    @Override
    public List<Menu> getMenuList() {
        return List.of(
                new Menu(1, "아메리카노", 2500),
                new Menu(2, "카페라떼", 3000),
                new Menu(3, "카푸치노", 2800)
        );
    }
}
