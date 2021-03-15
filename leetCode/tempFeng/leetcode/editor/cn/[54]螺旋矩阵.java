//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [
// [1,2,3],
// [4,5,6],
// [7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [
// [1,2,3,4],
// [5,6,7,8],
// [9,10,11,12]
// ]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 694 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {


    }

    /**
     *
     * @param mat 迭代的二维数据
     * @param flag 哪些数被访问过了
     * @param x 当前需要访问的数的 x 坐标
     * @param y 当前需要访问的数的 y 坐标
     * @param dir 当前访问的方向
     * @param res 结果
     */
    public void exFun(int[][] mat, boolean[][] flag, int x, int y, int dir, List<Integer> res) {
        // 首先，去判断，自己上下左右，是否能否访问
        int topX = x - 1;
        int topY = y;

        int bomX = x + 1;
        int bomY = y;

        int rightX = x;
        int rightY = y + 1;

        int leftX = x;
        int leftY = y - 1;

        boolean isConatinTop = isContain(mat, topX, topY);

        boolean isContainBom = isContain(mat, bomX, bomY);

        boolean isContainRight = isContain(mat, rightX, rightY);

        boolean isContainLeft = isContain(mat, leftX, leftY);

        flag[x][y] = true;
        res.add(mat[x][y]);

        // 如果包含自己上下左右，而且上下左右全部被访问过了

        boolean isAskTop = isAsk(flag, topX, topY);

        boolean isAskBom = isAsk(flag, bomX, bomY);

        boolean isAskRight = isAsk(flag, rightX, rightY);

        boolean isAskLeft = isAsk(flag, leftX, leftY);

        if ( isConatinTop && isContainBom && isContainRight && isContainLeft ) {
            if ( isAskTop && isAskBom && isAskRight && isAskLeft ) {
                return ;
            }
        }

        // 现在，要去寻找下一个节点数据，通过 res 来判断

        // 横向
        if ( 0 == dir ) {
            // 判断自己的右边那个节点，能不能访问
            if ( isContainRight ) {
                // 先去判断当前节点是否已经被访问过了
                boolean isAsk = isAsk(flag, rightX, rightY);
                // 如果被访问过了，则需要转变方向，
                if ( isAsk ) {
                    exFun(mat, flag, bomX, bomY, 1, res);
                } else {
                    // 如果没有被访问过，则继续向右边
                    exFun(mat, flag, rightX, rightY, 0, res);
                }
            } else {
                // 如果，不包含，也需要转变方向
                exFun(mat, flag, bomX, bomY, 1, res);
            }
        } else if ( 1 == dir ) {
            // 判断自己的下边那个节点，能不能访问
            if ( isContainBom ) {
                // 先去判断当前节点是否已经被访问过了
                boolean isAsk = isAsk(flag, rightX, rightY);
                // 如果被访问过了，则需要转变方向，
                if ( isAsk ) {
                    exFun(mat, flag, bomX, bomY, 1, res);
                } else {
                    // 如果没有被访问过，则继续向右边
                    exFun(mat, flag, rightX, rightY, 0, res);
                }
            } else {
                // 如果，不包含，也需要转变方向
                exFun(mat, flag, bomX, bomY, 1, res);
            }
        } else if ( 2 == dir ) {

        } else {

        }

        if (  ) {

        }
    }

    public boolean isAsk(boolean[][] flag, int x, int y) {
        return flag[x][y];
    }

    public boolean isContain(int[][] mat, int x, int y) {
        int length = mat.length;
        if ( x >= length ) {
            return false;
        }
        int col = mat[0].length;
        if ( y >= col ) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
