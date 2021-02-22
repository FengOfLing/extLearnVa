//给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。 
//
// 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [
// [1,2,3,4],
// [5,1,2,3],
// [9,5,1,2]]
//输出：true
//解释：
//在上述矩阵中, 其对角线为: 
//"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。 
//各条对角线上的所有元素均相同, 因此答案是 True 。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2],[2,2]]
//输出：false
//解释：
//对角线 "[1, 2]" 上的元素不同。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 20 
// 0 <= matrix[i][j] <= 99 
// 
//
// 
//
// 进阶： 
//
// 
// 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？ 
// 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？ 
// 
// Related Topics 数组 
// 👍 173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //取第一排数据的时候，可以用一个一维数组表示下一排的数据要求 [X,1,3,4]
        // X值可以取-1,-1值不在数组中存在，表示下一排对应位置是任意数字都能正确匹配
        int x = -1;
        int[] compare = new int[matrix[0].length];
        Arrays.setAll(compare,index->x);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = compare.length -1; j >= 0; j--) {
                //填充 compare
                if( j + 1 < compare.length){
                    compare[j+1] = matrix[i][j];
                }
                //比较 倒叙便于重复使用compare数组
                if(compare[j] == x){
                    continue;
                }
                if( compare[j] != matrix[i][j]){
                    return false; //直接返回
                }
            }
            compare[0] = x;//第一位永远是随意匹配
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
