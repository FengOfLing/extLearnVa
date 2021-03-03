//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums =
// [-2,1,-3,4,-1,2,1,-5,4]
// [-2,-1,-6,-2,-3,-1,0,-5,-1]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 示例 4：
//输入：nums = [-1]
//输出：-1
// 示例 5：
//输入：nums = [-100000]
//输出：-100000
// 提示：
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2937 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //解答成功:
        //			执行耗时:1 ms,击败了94.23% 的Java用户
        //			内存消耗:38.5 MB,击败了36.39% 的Java用户
        int minsum = nums[0];
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] =  nums[i] + (i == 0 ? 0 : nums[i-1]);
            result = Math.max( result ,Math.max(nums[i],nums[i]-minsum));
            minsum = Math.min(minsum,nums[i]);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
