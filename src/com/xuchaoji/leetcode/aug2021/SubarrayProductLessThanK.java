package com.xuchaoji.leetcode.aug2021;

import org.junit.Test;

/**
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2:
 *
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ZVAVXX
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 双指针法，左右指针从同一位置（0）开始，右指针右移，计算乘积
        // 统计当前以右指针结尾的子序列长度 right - left +1
        int res = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) { // 右指针右移
            product = product * nums[right]; // 计算从左指针到右指针的乘积
            while (left <= right && product >= k) {
                product = product / nums[left++]; // 左指针右移，同时除去product中乘的数
            }
            if (left <= right) {
                res = res + right - left + 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] input = new int[]{10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(input, 100));
    }
}
