//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 
//
// 示例： 
//
// 
//给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。 
// 
// Related Topics 动态规划 
// 👍 214 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int size = matrix.length;
        int length = matrix[0].length;
        sum = new int[size][length];
        for ( int i = 0; i < size; i++ ) {
            for ( int j = 0; j < length; j++ ) {
                sum[i][j] = muxRegin(i, j, matrix);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] + sum[row1][col1] - sum[row2][col1] - sum[row1][col2];
    }

    private int indexRegion(int row, int col, int[][] mat) {
        if ( row == 0 && col == 0 ) {
            return mat[0][0];
        } else {
            int rowCount = 0;
            for ( int i = 0; i < row; i++ ) {
                rowCount += mat[i][col];
            }
            int colCount = 0;
            for ( int j = 0; j < col; j++ ) {
                colCount += mat[row][j];
            }
            return rowCount + colCount + indexRegion(row - 1, col - 1, mat);
        }
    }

    private int muxRegin(int row, int col, int[][] mat) {
        if (  ) {

        }
        return muxRegin(row - 1, col, mat) +
                muxRegin( row, col - 1, mat ) -
                muxRegin(row - 1, col - 1, mat ) + mat[row][col];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
