package com.xuchaoji.leetcode.oct;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 你的面前有一堵矩形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
 *
 * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
 *
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
 *
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 示例：
 *
 * 输入: [[1,2,2,1],
 *       [3,1,2],
 *       [1,3,2],
 *       [2,4],
 *       [3,1,2],
 *       [1,3,1,1]]
 *
 * 输出: 2
 * https://leetcode-cn.com/problems/brick-wall
 */
public class LeastBricks {

    @Test
    public void test() {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<Integer>(Arrays.asList(100000000)));
        inputs.add(new ArrayList<Integer>(Arrays.asList(100000000)));
        inputs.add(new ArrayList<Integer>(Arrays.asList(100000000)));
        System.out.println(leastBricks(inputs));
    }

    public int leastBricks(List<List<Integer>> wall) {
        // 使用哈希表，遍历每行，记录砖块总长度sum和出现的次数。
        HashMap < Integer, Integer > map = new HashMap < > ();
        for (List < Integer > row: wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }
        int res = wall.size();
        for (int key: map.keySet())
            res = Math.min(res, wall.size() - map.get(key));
        return res;
    }

    // 最小步长优化
    /*public int leastBricks(List < List < Integer >> wall) {
        int[] pos = new int[wall.size()];
        int sum = 0, res = Integer.MAX_VALUE;
        for (int el: wall.get(0))
            sum += el;
        while (sum != 0) {
            int count = 0, mini = Integer.MAX_VALUE;
            for (int i = 0; i < wall.size(); i++) {
                List < Integer > row = wall.get(i);
                if (row.get(pos[i]) != 0) {
                    count++;
                } else
                    pos[i]++;
                mini = Math.min(mini, row.get(pos[i]));
            }
            for (int i = 0; i < wall.size(); i++) {
                List < Integer > row = wall.get(i);
                row.set(pos[i], row.get(pos[i]) - mini);
            }
            sum -= mini;
            res = Math.min(res, count);
        }
        return res;
    }*/

    // 超出内存限制
    /*public int leastBricks(List<List<Integer>> wall) {
        List<Integer> ans = new ArrayList<>();
        int length = getFullLength(wall.get(0));
        // 步长为1，内存超限。
        // 考虑使用最小砖块宽度为步长
        for (int i = 0; i < length; i++) {
            int throughTime = 0;
            for (List<Integer> lineWall : wall) {
                if (isThrough(lineWall, i)) {
                    throughTime++;
                }
            }
            ans.add(throughTime);
        }
        Collections.sort(ans);
        return ans.get(0);
    }

    public boolean isThrough(List<Integer> wall, int line) {
        int sum = 0;
        for (int i : wall) {
            sum += i;
            if (sum == line) {
                return false;
            }
            if (sum > line) {
                return true;
            }
        }
        return true;
    }

    public int getFullLength(List<Integer> wall) {
        int fullLength = 0;
        for (int i : wall) {
            fullLength += i;
        }
        return fullLength;
    }

    public int getStepLength(int count, List<List<Integer>> walls) {
        int ans = Integer.MAX_VALUE;
        for (List<Integer> line : walls) {
            if (count <= line.size()) {
                ans = Math.min(ans, line.get(count - 1));
            }
        }
        return ans;
    }*/
}
