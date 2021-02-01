package org.edu.cqu.learn.design.singleton;

public class ExtStaticSingleTon {

    private static ExtStaticSingleTon SINGLE_TON = null;

    private ExtStaticSingleTon() {

    }

    /**
     * 多个线程进来，会重复生成实例
     * @return 不唯一实例
     */
    public static ExtStaticSingleTon getInstance() {
        if ( null == SINGLE_TON ) {
            SINGLE_TON = new ExtStaticSingleTon();
        }
        return SINGLE_TON;
    }
}
