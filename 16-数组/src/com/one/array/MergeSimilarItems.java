package com.one.array;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @description: 2363. 合并相似的物品
 * 给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
 * items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
 * items 中每件物品的价值都是 唯一的 。
 * 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 。
 * 注意：ret 应该按价值 升序 排序后返回
 * @author: wanjunjie
 * @date: 2025/01/08
 */
public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // 对价值重复的元素进行重量累加
        for (int[] arr1 : items1) {
            treeMap.compute(arr1[0], (key, value) -> {
                if (value == null) {
                    return arr1[1];
                } else {
                    return value + arr1[1];
                }
            });
        }
        for (int[] arr2 : items2) {
            treeMap.compute(arr2[0], (key, value) -> {
                if (value == null) {
                    return arr2[1];
                } else {
                    return value + arr2[1];
                }
            });
        }
        return treeMap.entrySet().stream().map(entry -> Arrays.asList(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }
}
