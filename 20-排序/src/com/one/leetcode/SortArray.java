package com.one.leetcode;

/**
 * @description: 对数组进行排序
 * @author: wanjunjie
 * @date: 2025/02/25
 */
public class SortArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums;
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int pivotIndex = pivotIndex(nums, begin, end);
        quickSort(nums, begin, pivotIndex);
        quickSort(nums, pivotIndex + 1, end);
    }

    private int pivotIndex(int[] nums, int begin, int end) {
        int swap = (int) (Math.random() * (end - begin)) + begin;
        int temp = nums[begin];
        nums[begin] = nums[swap];
        nums[swap] = temp;

        temp = nums[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                if (nums[end] > temp) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }

            while (begin < end) {
                if (nums[begin] < temp) {
                    begin++;
                } else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        nums[begin] = temp;
        return begin;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 5));
        }
    }
}
