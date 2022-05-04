package com.xuchaoji.leetcode.may2022;

public class MaxSquare {

    /**
     * dp(i, j)表示以第i行，j列为正方形右下角，且正方形内值都为1的最大矩形面积。
     * 状态转移方程：dp(i,j)=min{dp(i−1,j), dp(i−1,j−1), dp(i,j−1)} + 1
     * @param matrix 输入矩阵
     * @return 只包含1的最大正方形面积。
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0; // 正方形边长
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { // 矩阵为null或宽高为0.
            return maxSide;
        }
        int rows = matrix.length; // 行
        int columns = matrix[0].length; // 列

        int[][] dp = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 遍历矩阵，第i行j列为1时，根据状态转移方程计算最大正方形面积。
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]); // 更新最大正方形边长。
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
