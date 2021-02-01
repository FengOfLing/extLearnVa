package org.edu.cqu.learn.design.adapter;

import java.util.logging.Logger;

public class Banner {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(Banner.class.getName());
    }

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    /**
     * 括号打印字符串
     */
    public void showWithParen() {
        LOGGER.info("(" + string + ")");
    }

    /**
     * 星号打印字符串
     */
    public void showWithAster() {
        LOGGER.info("*" + string + "*");
    }
}
