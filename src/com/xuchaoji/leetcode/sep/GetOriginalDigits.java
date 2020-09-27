package com.xuchaoji.leetcode.sep;

import org.junit.Test;

/**
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 *
 * 注意:
 *
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * 示例 1:
 *
 * 输入: "owoztneoer"
 *
 * 输出: "012" (zeroonetwo)
 *
 */
public class GetOriginalDigits {
    @Test
    public void test() {
        String input = "fviefuro";
        System.out.println(originalDigits(input));
    }

    // one two three four five six seven eight nine zero
    //      w         u         x          g         z    [0, 2, 4, 6, 8]
    // o: one two four zero [0, 1, 2, 4, 6, 8]
    // t: two three eight [0, 1, 2, 3, 4, 6, 8]
    // f: four five [0, 1, 2, 3, 4, 5, 6, 8]
    // s: six seven [0, 1, 2, 3, 4, 5, 6, 7, 8]
    // i: five six eight [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    // todo https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/submissions/
    // fix bug
    public String originalDigits(String s) {
        String ans = null;
        int[] input = new int['a' + 26];
        for (char letter : s.toCharArray()) {
            input[letter]++;
        }
        int[] nums = new int[10];
        nums[0] = input[(int)'z'];
        nums[2] = input[(int)'w'];
        nums[4] = input[(int)'u'];
        nums[6] = input[(int)'x'];
        nums[8] = input[(int) 'g'];
        nums[1] = input['o'] - nums[2] - nums[4] - nums[0];
        nums[3] = input['t'] - nums[2] - nums[8];
        nums[5] = input['f'] - nums[4];
        nums[7] = input['s'] - nums[6];
        nums[9] = input['i'] - nums[5] - nums[6];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i);
            }
        }
        ans = sb.toString();
        return ans;
    }
}
