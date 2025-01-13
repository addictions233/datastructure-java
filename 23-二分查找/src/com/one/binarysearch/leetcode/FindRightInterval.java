package com.one.binarysearch.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @description: 436. 寻找右区间
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * 区间 i 的 右侧区间 是满足 startj >= endi，且 startj 最小 的区间 j。注意 i 可能等于 j 。
 * 返回一个由每个区间 i 对应的 右侧区间 下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * @author: wanjunjie
 * @date: 2025/01/13
 */
public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> indexMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            indexMap.put(intervals[i][0], i);
        }
        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = indexMap.ceilingEntry(intervals[i][1]);
            if (Objects.nonNull(entry)) {
                result[i] = entry.getValue();
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] intervals = new int[][]{{3,4},{2,3},{1,2}};
        int[] rightInterval = findRightInterval(intervals);
        System.out.println(rightInterval);
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1,1);
        map.put(3,3);
        map.put(5,5);
        Map.Entry<Integer, Integer> lower = map.lowerEntry(3);
        Map.Entry<Integer, Integer> floor = map.floorEntry(3);
        System.out.println(lower.getKey());
        System.out.println(floor.getKey());
        Map.Entry<Integer, Integer> ceil = map.ceilingEntry(10);
        Map.Entry<Integer, Integer> higher = map.higherEntry(10);
        System.out.println(ceil.getKey());
        System.out.println(higher.getKey());
    }
}
