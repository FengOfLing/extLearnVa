//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 607 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        //			解答成功:
        //			执行耗时:1 ms,击败了100.00% 的Java用户
        //			内存消耗:35.9 MB,击败了5.04% 的Java用户
        return ((Double) Math.sqrt( x)).intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
