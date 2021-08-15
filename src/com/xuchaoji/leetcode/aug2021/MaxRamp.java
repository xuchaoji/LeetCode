package com.xuchaoji.leetcode.aug2021;

import org.junit.Test;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 *
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 *
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-ramp
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxRamp {
    public int maxWidthRamp(int[] nums) {
        int maxRamp = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (maxRamp > length - i) {
                break;
            }
            for (int j = i + 1; j < length; j++) {
                if (nums[j] >= nums[i] && (j - i) >= maxRamp) {
                    System.out.println("left index: " + i + ", value: " + nums[i]);
                    System.out.println("right index: " + j + ", value: " + nums[j]);
                    maxRamp = j - i;
                }
            }
        }
        return maxRamp;
    }

    /**
     * 外层循环从最大坡度开始遍历，直到长度变为1；
     * 内层循环遍历滑动窗口的前面那一位。
     * 返回第一个满足条件的坡度值即是最大坡度。
     */

    public int bestSolution(int[] nums) {
        for (int j = nums.length - 1; j > 0; j--) {
            for (int i = 0; i < nums.length - j; i++) {
                if (nums[i + j] >= nums[i]) {
                    return j;
                }
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] input = new int[]{6, 0, 8, 2, 1, 5};
        int[] input2 = new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(maxWidthRamp(input2));
    }
}
