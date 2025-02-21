package com.one.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题
 * @author: wanjunjie
 * @date: 2025/02/20
 */
public class FindKthLargest {
    /**
     * top k问题: 维护一个size=k的小堆, 如果新遍历到的元素比堆顶元素大,则加入堆, 然后下虑
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        // 建堆
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            Integer peek = priorityQueue.peek();
            if (peek < nums[i]) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.peek();
    }

    /**
     * JDK中提供的PriorityQueue默认是小堆minHeap, 如果我们想建大堆, 使用 Comparator.reverseOrder()
     */
    public void maxHeap(){
        // 创建一个最大堆的PriorityQueue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // 添加元素到最大堆
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(8);
        maxHeap.add(1);

        // 遍历并打印最大堆中的元素
        while (!maxHeap.isEmpty()) {
            // 移除并返回队列头部的元素（最大的）
            System.out.println(maxHeap.poll());
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,2,5,6,8,0,3};
        int result = findKthLargest(nums, 2);
        System.out.println(result);
    }
}
