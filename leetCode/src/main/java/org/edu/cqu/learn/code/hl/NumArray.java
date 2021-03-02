package org.edu.cqu.learn.code.hl;

public class NumArray {
    int[] summary ;
    public NumArray(int[] nums) {
        summary = new int[nums.length];
        summary[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            summary[i] = summary[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return summary[j] - (i == 0 ? 0 : summary[i-1]);
    }
}
