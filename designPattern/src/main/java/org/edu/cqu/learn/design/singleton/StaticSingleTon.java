package org.edu.cqu.learn.design.singleton;

public class StaticSingleTon {

    private static final StaticSingleTon SINGLE_TON;

    static {
        SINGLE_TON = new StaticSingleTon();
    }

    private StaticSingleTon() {

    }

    /**
     * 当调用这个静态方法的时候，JVM 会执行一次 static 的代码块
     * 而且只会执行一次，这是根据虚拟机的特性来的
     * @return 唯一实例
     */
    public StaticSingleTon getSingleTon() {
        return SINGLE_TON;
    }

}
