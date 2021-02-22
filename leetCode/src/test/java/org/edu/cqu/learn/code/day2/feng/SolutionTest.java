package org.edu.cqu.learn.code.day2.feng;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void context() {
        int[][] max = new int[3][4];
        max[0][0] = 1;
        max[0][1] = 2;
        max[0][2] = 3;
        max[0][3] = 4;

        max[1][0] = 5;
        max[1][1] = 1;
        max[1][2] = 2;
        max[1][3] = 3;

        max[2][0] = 9;
        max[2][1] = 5;
        max[2][2] = 1;
        max[2][3] = 2;

        boolean res = Solution.isToeplitzMatrix(max);
    }

}
