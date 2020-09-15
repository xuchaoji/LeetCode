package com.xuchaoji.leetcode.sep;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：
 * 要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 */
public class DayliyTempe {


    // 可以维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。
    // 如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> indexStack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            // 栈非空，且当前index对应的气温大于栈顶index对应的气温。
            while (!indexStack.isEmpty() && T[i] > T[indexStack.peek()]) {
                int preIndex = indexStack.pop();
                ans[preIndex] = i - preIndex;
            }
            // 栈为空或当前index的气温不大于栈顶index对应的气温，当前气温index入栈
            indexStack.push(i);
        }
        return ans;
    }

    // 复杂度过高
    /*public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = i + 1; j < length; j++) {
                ++count;
                if (T[i] < T[j]) {
                    ans[i] = count;
                    break;
                }
            }
        }
        return ans;
    }*/
}
