//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limi
//t 。 
//
// 如果不存在满足条件的子数组，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,2,4,7], limit = 4
//输出：2 
//解释：所有子数组如下：
//[8] 最大绝对差 |8-8| = 0 <= 4.
//[8,2] 最大绝对差 |8-2| = 6 > 4. 
//[8,2,4] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//[2] 最大绝对差 |2-2| = 0 <= 4.
//[2,4] 最大绝对差 |2-4| = 2 <= 4.
//[2,4,7] 最大绝对差 |2-7| = 5 > 4.
//[4] 最大绝对差 |4-4| = 0 <= 4.
//[4,7] 最大绝对差 |4-7| = 3 <= 4.
//[7] 最大绝对差 |7-7| = 0 <= 4. 
//因此，满足题意的最长子数组的长度为 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1,2,4,7,2], limit = 5
//输出：4 
//解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
// 
//
// 示例 3： 
//
// 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 0 <= limit <= 10^9 
// 
// Related Topics 数组 Sliding Window 
// 👍 141 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路是什么
    // 首先从第 i 位 开始，
    // 向后延展 j 位，拿到子数组
    // 这里的 j 是有限定值的，就是 i + j < length
    // 然后，找到子数组中最小的数和最大的数
    // 做减法，如果小于等于限定值，则 j + 1
    // 继续以上循环
    // 否则，记录下 j 值
    // 直到 i = length - 1
    public int longestSubarray(int[] nums, int limit) {
        int result = 0;
        for ( int i = 0; i < nums.length; i ++ ) {
            //
            int max = nums[i];
            int min = nums[i];
            for ( int j = i; j < nums.length; j++ ) {
                if ( nums[j] > max ) {
                    max = nums[j];
                }
                if ( nums[j] < min ) {
                    min = nums[j];
                }
                if ( max - min > limit ) {
                    break;
                }

                if ( result < j - i + 1 ) {
                    result = j - i + 1;
                }
            }
            if ( i + result == nums.length ) {
//                break;
                return result;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
