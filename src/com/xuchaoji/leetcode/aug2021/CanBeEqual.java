package com.xuchaoji.leetcode.aug2021;

import java.util.HashMap;
import java.util.Map;

public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int number : arr) {
            if (tmp.containsKey(number)) {
                int res = tmp.get(number) + 1;
                tmp.put(number, res);
            } else {
                tmp.put(number, 1);
            }
        }

        for (int num : target) {
            if (tmp.containsKey(num) && tmp.get(num) > 0) {
                tmp.put(num, tmp.get(num) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
