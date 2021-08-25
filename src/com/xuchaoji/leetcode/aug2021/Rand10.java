package com.xuchaoji.leetcode.aug2021;

import org.junit.Test;

public class Rand10 {
    // 生成 1~49 拒绝 41~49， 取余
    // 直接两次rand7() 1~40 每个数生成概率不相等，1 = 1*1， p = 1/49; 4 = 1*4, 4*1, 2*2, 2*2 p = 4/49;
    // (rand7() - 1) * 7 + rand7(), 用随机生成的7 填满间隙
    public int rand10() {
        int num;
        do {
            num = (rand7() - 1) * 7 + rand7();
        } while (num > 40);
        return num % 10 + 1;
    }

    public int rand7() {
        return (int) Math.floor(Math.random() * (8 - 1)) + 1; //不含最大值，含最小
    }

    @Test
    public void test() {
        while (true) {
            System.out.println(rand10());
        }
    }
}
