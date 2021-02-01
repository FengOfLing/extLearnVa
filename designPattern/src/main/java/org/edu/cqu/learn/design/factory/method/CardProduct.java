package org.edu.cqu.learn.design.factory.method;

public class CardProduct extends Product {
    public CardProduct(String name) {
        super(name);
    }

    @Override
    void use() {
        System.out.println("学生卡使用");
    }
}
