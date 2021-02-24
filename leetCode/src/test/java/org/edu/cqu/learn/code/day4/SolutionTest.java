package org.edu.cqu.learn.code.day4;

import org.edu.cqu.learn.code.day4.feng.Solution;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void context() {
        int[][] a = new int[4][4];
        a[0][0] = 1;
        a[0][1] = 1;
        a[0][2] = 0;
        a[0][3] = 0;

        a[1][0] = 1;
        a[1][1] = 0;
        a[1][2] = 0;
        a[1][3] = 1;

        a[2][0] = 0;
        a[2][1] = 1;
        a[2][2] = 1;
        a[2][3] = 1;

        a[3][0] = 1;
        a[3][1] = 0;
        a[3][2] = 1;
        a[3][3] = 0;

        int[][] b = Solution.flipAndInvertImage(a);

    }
}
