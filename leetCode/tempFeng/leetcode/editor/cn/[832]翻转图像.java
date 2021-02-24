//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。 
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。 
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。 
//
// 
//
// 示例 1： 
//
// 
//输入：[[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = A[0].length <= 20 
// 0 <= A[i][j] <= 1 
// 
// Related Topics 数组 
// 👍 212 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 思路是什么，我反正没看懂
    // 就是说，先将二维数组中的每一个数组，的元素顺序交换一下
    // 然后取反
    // 可以一个一个数组的处理
    public int[][] flipAndInvertImage(int[][] A) {
        //
        for ( int i = 0; i < A.length; i++ ) {
            // 每一个元素
            // 从两边向中间遍历
            for ( int j = 0; j < A[i].length / 2; j ++ ) {
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length - j - 1];
                A[i][A[i].length - j - 1] = temp;
                // 现在去取反
                if ( A[i][j] == 0 ) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
                if ( A[i][A[i].length - j - 1] == 0 ) {
                    A[i][A[i].length - j - 1] = 1;
                } else {
                    A[i][A[i].length - j - 1] = 0;
                }
            }
            if ( A[i].length % 2 != 0 ) {
                int minIndex = A[i].length / 2;
                if ( A[i][minIndex] == 0 ) {
                    A[i][minIndex] = 1;
                } else {
                    A[i][minIndex] = 0;
                }
            }
        }
        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
