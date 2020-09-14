package com.xuchaoji.leetcode.sep;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 */
public class ValidBrackets {

    public static void main(String[] args) {
        String input = "((){}[])";
        System.out.println("isValid: "+ isValid(input));
    }


    public static boolean isValid(String s) {

        int n = s.length();
        // 奇数，肯定无效
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        // 栈的相关知识点参考：https://www.liaoxuefeng.com/wiki/1252599548343744/1265121668997888
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                // 匹配到可关闭的括号，出栈
                stack.pop();
            } else {
                // 未匹配到可关闭的括号，入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
