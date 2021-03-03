//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//  1   -   1
//  2   -   2
//  3   -   3
//  4   -   爬到3再跳一步 或者爬到2再跳两步 = nums[3] +  nums[2] = 5
// Related Topics 动态规划 (找规律）
// 👍 1507 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        //			解答成功:
        //			执行耗时:0 ms,击败了100.00% 的Java用户
        //			内存消耗:35.2 MB,击败了50.47% 的Java用户
        int prepre = 1;
        int pre = 2;
        if( n == 1 ){
            return 1;
        }
        if( n == 2){
            return 2;
        }
        for (int i = 3; i < n ; i++) {
            int oldpre = pre;
            pre = pre + prepre;
            prepre = oldpre;
        }
        return pre+prepre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
