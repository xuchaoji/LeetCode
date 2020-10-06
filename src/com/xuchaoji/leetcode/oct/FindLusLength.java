package com.xuchaoji.leetcode.oct;

import org.junit.Test;

/**
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 *
 * 示例 1：
 *
 * 输入: "aba", "cdc", "eae"
 * 输出: 3
 */
public class FindLusLength {

    @Test
    public void test() {
        String[] inputs = new String[]{"aba", "cdc", "eae"};
        System.out.println(findLUSlength(inputs));
    }

    // 找出两个字符串中较短的一个，判断较短的字符串的子串是否在长字符串中。×，ad是abcd的子串

    // 如果存在这样的特殊序列，那么它一定是某个给定的字符串。
    //
    //检查每个字符串是否是其他字符串的子序列。如果不是，则它是一个特殊序列。最后返回长度最大的特殊序列。如果不存在特殊序列，返回 -1。
    //
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (j == i)
                    continue;
                if (isSubsequence(strs[i], strs[j]))
                    break;
            }
            if (j == strs.length)
                res = Math.max(res, strs[i].length());
        }
        return res;
    }

    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
}
