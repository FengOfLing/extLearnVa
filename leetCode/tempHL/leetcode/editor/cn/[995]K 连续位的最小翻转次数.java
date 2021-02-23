//在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0
//。 
//
// 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [0,1,0], K = 1
//输出：2
//解释：先翻转 A[0]，然后翻转 A[2]。
// 
//
// 示例 2： 
//
// 
//输入：A = [1,1,0], K = 2
//输出：-1
//解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
// 
//
// 示例 3： 
//
// 
//输入：A = [0,0,0,1,0,1,1,0], K = 3
//输出：3
//解释：
//翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
//翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
//翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// 1 <= K <= A.length 
// 
// Related Topics 贪心算法 Sliding Window 
// 👍 190 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minKBitFlips(int[] A, int K) {
        int count = 0;
        //遇到A[i] == 0 就翻转 A[i]-A[i+k],如果i+k>=数组长度，则翻转失败，翻转后 从A[i+1]重复处理
        //如果每次翻转循环  A[i]-A[i+k]去修改，会出现超时
        for (int i = 0; i < A.length ; i++) {
            if(A[i] == 0){
                if( i + K > A.length){
                    return -1;
                }
                count ++;
                for (int j = 0; j < K ; j++) {
                    A[i+j] = A[i+j] == 0 ? 1 : 0;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
