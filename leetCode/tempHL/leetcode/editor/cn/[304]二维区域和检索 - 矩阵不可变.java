//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 示例: 
//
// 给定 matrix = [
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
// 说明: 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2。 
// 
// Related Topics 动态规划 
// 👍 161 👎 0

//分析
// 给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
// summary = [
//  [ 3,  3,  4, 8, 10],
//  [ 8, 14, 18, 24, 27],
//  [ 9, 17, 21, 28, 36],
//  [13, 22, 26, 34, 49],
//  [14, 23, 30, 38, 58]
// ]
//sumRegion(2, 1, 4, 3) = summary[4][3]-summary[2-1][3]-summary[4][1-1]+summary[2-1][1-1]
//  = 38-24-14+8 = 8


//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    //summary[i][j] 是指(0,0)到坐标(i,j)的总和
    // (m,n)到(i,j)的和为summary[i][j]-summary[i-m-1][j]-summary[i][j-n-1]+summary[m-1][n-1]
    int[][] summary;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0){
            summary = new int[1][1];//避免计算和的时候特殊处理空数组
        }else {
            summary = new int[matrix.length][matrix[0].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                summary[i][j] = matrix[i][j]
                        + (i == 0 ? 0 : summary[i-1][j] )
                        +(j == 0 ? 0 : summary[i][j-1])
                        -((j == 0 || i == 0) ? 0 : summary[i-1][j-1]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return summary[row2][col2]
                - (row1 == 0 ? 0 : summary[row1-1][col2])
                - (col1 == 0 ? 0 : summary[row2][col1-1])
                + (0 == col1 || 0 == row1 ? 0 : summary[row1-1][col1-1]);

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
