package org.edu.cqu.learn.design.factory.method;

/**
 * 默认的产品的统一抽象类
 */
public abstract class Product {
    private String name;
    abstract void use();

    public Product(String name) {
        this.name = name;
    }
}
