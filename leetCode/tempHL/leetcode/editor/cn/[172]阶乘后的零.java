//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 430 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //			解答成功:
    //			执行耗时:42 ms,击败了7.43% 的Java用户
    //			内存消耗:35.4 MB,击败了42.54% 的Java用户
    public int trailingZeroes(int n) {
        //10 = 2 * 5 只需要计算能被2整除的个数和被5整除的个数，取最小值即可
        int count2 = 0;
        int count5 = 0;
        for (int i = 2; i <= n ; i++) {
            int temp = i;
            while((temp % 2) == 0){
                count2 ++;
                temp /= 2;
            }
            while((temp % 5) == 0){
                count5 ++;
                temp /= 5;
            }
        }
        return Math.min(count2, count5);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
