package org.edu.cqu.learn.code;

import org.edu.cqu.learn.code.day1.Solution;
import org.junit.Test;

public class CodeApplicationTest {

    @Test
    public void context() {
        int[] nums = new int[6];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 1;
        nums[3] = 1;
        nums[4] = 1;
        nums[5] = 1;

//                nums[0] = 1;
//        nums[1] = 1;
//        nums[2] = 1;
//        nums[3] = 1;
        int result = Solution.longestSubarray(nums, 10);
        System.err.println(result);
    }
}
