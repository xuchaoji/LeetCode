package com.xuchaoji.leetcode.oct;

import org.junit.Test;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 */
public class Palindrome {

    @Test
    public void test() {
        int input = 122321;
        System.out.println(isPalindrome(input));
    }

    // 1221
    // 字符串，双指针
    // 反转数字本身
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        int reverse = 0;

        // 1221 reverse: 12, x: 12
        // 12321 reverse: 123, x: 12
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse/10;
    }
}
