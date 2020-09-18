package com.xuchaoji.leetcode.sep;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class TrapWater {

    @Test
    public void test() {
        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(input));
    }

    public int trap(int[] height) {
        int ans = 0;
        // 从左到右遍历数组，当比前一个数小，记下与左边最大值的落差，放到数组中。
        // 从右到左遍历数组，。。。
        // 从右到左和从左到右保存下来的两个数组对应位置的最小值即为当前位置可以存的水。
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        int[] leftWater = new int[length];
        int leftMax = 0;
        for (int leftCur = 1; leftCur < length; leftCur++) {
            if (height[leftCur - 1] > leftMax) {
                leftMax = height[leftCur - 1];
            }
            if (height[leftCur] < leftMax) {
                leftWater[leftCur] = leftMax - height[leftCur];
            }
        }
        int[] rightWater = new int[length];
        int rightMax = 0;
        for (int rightCur = length - 2; rightCur > 0; rightCur--) {
            if (height[rightCur + 1] > rightMax) {
                rightMax = height[rightCur + 1];
            }
            if (height[rightCur] < rightMax) {
                rightWater[rightCur] = rightMax - height[rightCur];
            }
        }
        return compareWater(leftWater, rightWater);
    }

    private int compareWater(int[] left, int[] right) {
        int length = Math.max(left.length, right.length);
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += Math.min(left[i], right[i]);
        }
        return ans;
    }
}
