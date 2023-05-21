package com.codestates.section2week3.di;

// 2023.5.15(월) 22h45
public class Menu {
    private long id;
    private String name;
    private int price;

    public Menu(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
