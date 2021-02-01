package org.edu.cqu.learn.design.prototype;

public interface Product extends Cloneable {
    void use(String s);
    Product createByClone();
}
