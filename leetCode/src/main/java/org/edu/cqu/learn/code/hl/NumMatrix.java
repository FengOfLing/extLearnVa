package org.edu.cqu.learn.code.hl;

public class NumMatrix {
    //summary[i][j] 是指(0,0)到坐标(i,j)的总和
    // (m,n)到(i,j)的和为summary[i][j]-summary[i-m-1][j]-summary[i][j-n-1]+summary[m-1][n-1]
    int[][] summary;
    public NumMatrix(int[][] matrix) {
        summary = new int[matrix.length][matrix[0].length];
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
