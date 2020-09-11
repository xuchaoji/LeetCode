package com.xuchaoji.leetcode.sep;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 */

public class MinmunEncoding {



    public int minimumLengthEncoding(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word);
        }
        // 遍历每个单词的后缀(不包含单词本身)，若hashSet中包含该元素，则从中删除
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                wordsSet.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String word : wordsSet) {
            ans += word.length() + 1;
        }
        return ans;
    }
}
