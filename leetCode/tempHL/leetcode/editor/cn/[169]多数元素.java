//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 常量空间不能统计 特征是超过一半数量
// Related Topics 位运算 数组 分治算法 
// 👍 903 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //			解答成功:
    //			执行耗时:1 ms,击败了99.99% 的Java用户
    //			内存消耗:42 MB,击败了36.61% 的Java用户
    public int majorityElement(int[] nums) {
        if( nums == null || nums.length == 0){
            return 0;
        }
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length ; i++) {
            if( num == nums[i]){
                count ++;
            }else{
                if( 0 == count--){
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
