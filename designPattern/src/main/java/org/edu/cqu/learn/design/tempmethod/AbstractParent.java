package org.edu.cqu.learn.design.tempmethod;

/**
 * 很少见的抽象父类
 */
public abstract class AbstractParent {
    public abstract boolean isSuccess();

    /**
     * 就是这种写法，我父类是可以有具体的方法的，当然抽象方法也可以
     * 但是抽象方法就不能这样写，因为抽象方法不能有实现体
     * @return 是否 -1
     */
    public int result() {
        boolean isSuccess = this.isSuccess();
        if ( isSuccess ) {
            return 0;
        } else {
            return -1;
        }
    }
}
