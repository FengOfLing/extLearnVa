//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 542 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int num) {
        //复杂度N做到，那么就是1的计数最好能依赖之前的结果直接取用
        //8-15 的计数就是 一个前置1 分别加上0-7的1的数量，这是二进制的特点
        int flag = 1;
        int[] result = new int[num+1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if(i == flag){
                result[i] = 1;
                flag = flag << 1;//下一个前置1的数字
            }else{
                result[i] = 1 + result[ i- (flag>>>1)];
            }
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
