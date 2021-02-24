package org.edu.cqu.learn.code.day4.feng;

public class Solution {
    public static int[][] flipAndInvertImage(int[][] A) {
        //
        for ( int i = 0; i < A.length; i++ ) {
            // 每一个元素
            // 从两边向中间遍历
            for ( int j = 0; j < A[i].length / 2; j ++ ) {
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length - j - 1];
                A[i][A[i].length - j - 1] = temp;
                // 现在去取反
                if ( A[i][j] == 0 ) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
                if ( A[i][A[i].length - j - 1] == 0 ) {
                    A[i][A[i].length - j - 1] = 1;
                } else {
                    A[i][A[i].length - j - 1] = 0;
                }
            }
            if ( A[i].length % 2 != 0 ) {
                int minIndex = A[i].length / 2;
                if ( A[i][minIndex] == 0 ) {
                    A[i][minIndex] = 1;
                } else {
                    A[i][minIndex] = 0;
                }
            }
        }
        return A;
    }
}
