package org.edu.cqu.learn.design.factory.method;

import java.util.LinkedList;
import java.util.List;

public abstract class ProductFactory {
    private List<Product> productList;

    public ProductFactory() {
        productList = new LinkedList<>();
    }

    public void register(Product product) {
        this.productList.add(product);
    }

    public abstract Product createProduct(String name) ;

    public Product getProduct(String name) {
        // 调用抽象方法，去获取业务对象
        Product product = createProduct(name);
        this.register(product);
        return product;
    }
}
