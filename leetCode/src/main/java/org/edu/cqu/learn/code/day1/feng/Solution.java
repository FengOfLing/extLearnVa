package org.edu.cqu.learn.code.day1.feng;

public class Solution {

    public static int longestSubarray(int[] nums, int limit) {
        int result = 0;
        for ( int i = 0; i < nums.length; i ++ ) {
            //
            int max = nums[i];
            int min = nums[i];
            for ( int j = i; j < nums.length; j++ ) {
                if ( nums[j] > max ) {
                    max = nums[j];
                }
                if ( nums[i] < min ) {
                    min = nums[i];
                }
                if ( max - min > limit ) {
                    break;
                }
                if ( result < j - i + 1 ) {
                    result = j - i + 1;
                }
            }
        }
        return result;
    }
}
