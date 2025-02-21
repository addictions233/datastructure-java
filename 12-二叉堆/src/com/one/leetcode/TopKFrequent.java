package com.one.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * @author: wanjunjie
 * @date: 2025/02/21
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, Map.Entry.comparingByValue());
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i < k) {
                priorityQueue.offer(entry);
            } else {
                Map.Entry<Integer, Integer> peek = priorityQueue.peek();
                if (peek.getValue() < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }
            }
            i++;
        }
        return priorityQueue.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}
