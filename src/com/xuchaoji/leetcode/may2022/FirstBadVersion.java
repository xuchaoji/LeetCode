package com.xuchaoji.leetcode.may2022;

import org.junit.Test;

public class FirstBadVersion {
    private int badVer = 0;

    @Test
    public void test() {
        int n = 9;
        badVer = 4;
        System.out.println("bad version is: " + firstBadVersion(n));
    }

    boolean isBadVersion(int bad) {
        return bad >= badVer;
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int mid = left + (right - left) / 2;
        while (left < right && mid >= left && mid <= right) {
            if (isBadVersion(mid)) { // mid is bad， bad version between [left, mid]
                right = mid;
            } else { // mid is ok, bad version between [left + 1, right]
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return mid;
    }
}
