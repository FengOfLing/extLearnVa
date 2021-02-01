package org.edu.cqu.learn.desgin.tempmethod;

import org.edu.cqu.learn.design.tempmethod.AbstractParent;
import org.edu.cqu.learn.design.tempmethod.RealSun;
import org.junit.Test;

public class TempMethodTest {

    @Test
    public void context() {
        AbstractParent parent = new RealSun();
        int result = parent.result();
        System.out.println(result);
    }
}
