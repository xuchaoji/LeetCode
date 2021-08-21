package com.xuchaoji.leetcode.aug2021;

import org.junit.Test;

/**
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 *
 * 请你返回最终这些形体的总表面积。
 *
 * 注意：每个形体的底面也需要计入表面积中。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [[2]]
 * 输出：10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SurfaceAreas {
    /**
     * 每个高为n的柱体，贡献表面积2+4n
     * 高为j和k的两个柱体相邻，贴合处损失面积为min{j, k} * 2
     * 为避免重复减去贴合处面积，每个柱体只计算右测和下方的相邻面积。
     * @param grid 输入
     * @return 表面积
     */
    public int surfaceArea(int[][] grid) {
        int length = grid[0].length;
        if (length == 1) {
            if (grid[0][0] == 0) {
                return 0;
            }
            return grid[0][0] * 4 + 2;
        }
        int totalArea = 0;
        int lossArea = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                totalArea = totalArea + (grid[i][j] * 4 + 2);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int local = grid[i][j];
                if (local == 0) {
                    continue;
                }
                int right = (j + 1) > length-1 ? 0 : grid[i][j + 1];
                int down = (i + 1) > length -1 ? 0 : grid[i + 1][j];
                int loss = Math.min(local, right) + Math.min(local, down);
                lossArea = lossArea + loss * 2;
            }
        }
        return totalArea - lossArea;
    }

    @Test
    public void test() {
        int[][] intput = {{2}};
        System.out.println(surfaceArea(intput));
    }
}
