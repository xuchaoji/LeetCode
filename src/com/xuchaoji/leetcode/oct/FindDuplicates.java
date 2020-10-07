package com.xuchaoji.leetcode.oct;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */

public class FindDuplicates {
    // 1 ≤ a[i] ≤ n
    // 遍历到数字x时，将Index为x-1的数组变为负数，如果已经是负数，则x是重复数字
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int x : nums) {
            if (x < 0) {
                x = -x;
            }
            if (nums[x - 1] < 0) {
                ans.add(x);
            } else {
                nums[x - 1] = -nums[x - 1];
            }
        }
        return ans;
    }
}
