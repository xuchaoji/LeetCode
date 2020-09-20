package com.xuchaoji.leetcode.sep;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {


    /**
     * 以f(i)表示已num[i]结尾的连续数组的最大和，求f(i)在i属于[0, n-1]区间的最大值。
     * f(i-1) 为 以 num[i - 1]结尾的连续数组最大和，
     * 则以f(i)结尾的连续数组最大和为：Math.max(f(i-1) + num[i], num[i]);
     * @param nums 输入数组。
     * @return
     */
    public int maxSubArray(int[] nums) {

        int preResult = 0;
        int ans = nums[0];
        for (int num : nums) {
            preResult = Math.max(preResult + num, num);
            if (preResult > ans) {
                ans = preResult;
            }
        }
        return ans;
    }
}
