package org.edu.cqu.learn.code.day2.feng;

public class Solution {


    public static boolean isToeplitzMatrix(int[][] matrix) {
        // 先横向遍历
        //
        int firstLength = matrix[0].length;
        for ( int i = 0; i < firstLength; i++ ) {
            // 拿到第一个元素，先判断是否存在
            int x = 0;
            int y = i;
            int flag = matrix[x][y];
            while ( x < matrix.length && y < matrix[x].length ) {
                if ( flag != matrix[x][y] ) {
                    return false;
                }
                x ++;
                y ++;
            }
        }
        // 横向遍历完毕了，接下来是纵向遍历
        // 遍历的第一个数是 1 0
        // 第二个数是 2 1
        int length = matrix.length;
        for ( int j = 1; j < length; j++ ) {
            int x = j;
            int y = 0;
            int yFlag = matrix[x][y];
            while ( x < matrix.length && y < matrix[x].length ) {
                if ( yFlag != matrix[x][y] ) {
                    return false;
                }
                x ++;
                y ++;
            }
        }
        return true;
    }

}
