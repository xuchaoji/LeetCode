package com.xuchaoji.leetcode.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        // 找到四个顶点，每次不超过四个顶点，顺时针走完一圈后顶点向里缩
        int top = 0;
        int right = column - 1;
        int bottom = row - 1;
        int left = 0;
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int currentColumn = left; currentColumn <= right; currentColumn++) {
                ans.add(matrix[top][currentColumn]);
            }
            // 从上到下
            for (int currentRow = top + 1; currentRow <= bottom; currentRow++) {
                ans.add(matrix[currentRow][right]);
            }

            if (left < right && top < bottom) {
                // 从右到左
                for (int currentColumn = right - 1; currentColumn > left; currentColumn--) {
                    ans.add(matrix[bottom][currentColumn]);
                }
                // 从下到上
                for (int currentRow = bottom; currentRow > top; currentRow--) {
                    ans.add(matrix[currentRow][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
