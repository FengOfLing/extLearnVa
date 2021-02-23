package org.edu.cqu.learn.code.day3;

import org.edu.cqu.learn.code.day3.feng.Solution;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void context() {
        int[] c = new int[8];
        c[0] = 1;
        c[1] = 0;
        c[2] = 1;
        c[3] = 2;
        c[4] = 1;
        c[5] = 1;
        c[6] = 7;
        c[7] = 5;

        int[] g = new int[8];
        g[0] = 0;
        g[1] = 1;
        g[2] = 0;
        g[3] = 1;
        g[4] = 0;
        g[5] = 1;
        g[6] = 0;
        g[7] = 1;

        int res = Solution.maxSatisfied(c, g, 3);
        System.err.println(0);
    }
}
