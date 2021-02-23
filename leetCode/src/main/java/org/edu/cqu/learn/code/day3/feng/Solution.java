package org.edu.cqu.learn.code.day3.feng;

public class Solution {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result = 0;
        int tempResult = 0;
        int nextRes = 0;
        for ( int i = 0; i < X; i++ ) {
            tempResult += customers[i];
        }
        for ( int i = X; i < customers.length; i++ ) {
            if ( 0 == grumpy[i] ) {
                tempResult += customers[i];
            }
        }
        if ( result < tempResult ) {
            result = tempResult;
        }
        nextRes = tempResult;
        // 算出来了之后，我们再根据这个值，去一次一次的计算后面的值
        for ( int j = 1; j <= customers.length - X; j ++ ) {
            if ( 1 == grumpy[j - 1] ) {
                nextRes -= customers[j - 1];
            }
            if ( 1 == grumpy[j + X - 1] ) {
                nextRes += customers[j + X - 1];
            }
            if ( result < nextRes ) {
                result = nextRes;
            }
        }
        return result;
    }
}
