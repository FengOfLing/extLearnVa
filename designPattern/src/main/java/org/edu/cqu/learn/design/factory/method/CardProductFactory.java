package org.edu.cqu.learn.design.factory.method;

public class CardProductFactory extends  ProductFactory {
    @Override
    public Product createProduct(String name) {
        return new CardProduct(name);
    }
}
