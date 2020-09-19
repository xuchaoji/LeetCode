package com.xuchaoji.leetcode.sep;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRetangleArea {
    @Test
    public void test() {
        int[] input = new int[]{2,1,2};
        System.out.println(largestRectangleArea(input));
    }
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        int[] areas = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("====================");
            areas[i] = getAreaByHeight(i, heights);
            System.out.println("getArea: " + i + ", size: " + areas[i]);
        }
        int[] revertHeight = reserve(heights);
        int[] reverseAreas = new int[length];
        /*for (int i = 0; i < length; i++) {
            reverseAreas[i] = getAreaByHeight(i, revertHeight);
        }*/
        List<Integer> areasList = new ArrayList<>();
        Arrays.sort(areas);
        Arrays.sort(reverseAreas);
        ans = Math.max(areas[length - 1], reverseAreas[length - 1]);
        return ans;
    }

    // todo 需要向两侧延伸
    private int getAreaByHeight(int index, int[] heights) {
        int minArea = heights[index];
        int areaSize = minArea;
        int length = heights.length;
        if (length == 1) {
            return minArea;
        }
        for (int i = index + 1; i < length; i++) {
            if (heights[i] >= minArea) {
                areaSize += minArea;
                System.out.println("right bigger, minSize ++");
            } else {
                break;
            }
        }
        if (index > 0) {
            for (int i = index - 1; i >= 0; i--) {
                if (heights[i] >= minArea) {
                    areaSize += minArea;
                    System.out.println("left bigger, minSize ++");
                } else {
                    break;
                }
            }
        }
        return areaSize;
    }

    public static int[] reserve( int[] arr ){
        int[] arr1 = new int[arr.length];
        for( int x=0;x<arr.length;x++ ){
            arr1[x] = arr[arr.length-x-1];
        }
        return arr1 ;
    }
}
