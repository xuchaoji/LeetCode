package com.xuchaoji.jysg.digui;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 */
public class ClimbStair {
    // 动态规划
    // f(i) = f(i-1) + f(i-2)
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    // 递归
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    // 递归 带缓存 解决时间复杂度问题
    public int climbStairs3(int n) {
        int[] memo = new int[n + 1];
        return climb(n, memo);
    }

    public int climb(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = climb(n - 1, memo) + climb(n - 1, memo);
        return memo[n];
    }
}
