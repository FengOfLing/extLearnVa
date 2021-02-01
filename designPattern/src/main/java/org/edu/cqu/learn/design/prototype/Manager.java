package org.edu.cqu.learn.design.prototype;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showCase = new HashMap<>();

    public void register(String name, Product product) {
        showCase.put(name, product);
    }

    public Product create(String name) {
        Product caseI = showCase.get(name);
        if ( null != caseI ) {
            return caseI.createByClone();
        }
        return null;
    }
}
