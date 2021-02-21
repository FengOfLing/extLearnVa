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
// 👍 100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //  循环以数组每个数字为起点，找到满足条件的最大子串长度
        //  然后和之前的最大长度比较，大则更新结果，小则跳过下一个数字为起点

        //最大子串长度
        int maxResult = 0 ;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int maxindex = i;
            int minindex = i;
            for ( ; j < nums.length ; j++) {
                if( nums[j] >= nums[maxindex]){
                    maxindex = j;
                }
                if( nums[j] <= nums[minindex]){
                    minindex = j;
                }
                if(Math.abs(nums[maxindex]-nums[minindex]) > limit ){
                    break;
                }
            }
            //当前循环的最大长度为j-i
            int curentResult = j-i ;
            maxResult = Math.max(curentResult,maxResult ) ;
            //减少循环 i+result如果等于了数组长度、剩余子串不会有更大的长度
            if( (i + maxResult ) == nums.length ){
                break;
            }
        }
        return maxResult ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
