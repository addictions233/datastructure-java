package com.one.binarysearch;

import java.util.Arrays;

/**
 * @description: 1385. 两个数组间的距离值
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * @author: wanjunjie
 * @date: 2024/12/13
 */
public class FindTheDistanceValue {

    /**
     * 如arr2[]中没有元素满足在[arr[i] - d, arr[i] + d]区间, 就将结果 +1
     */
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int result = 0;
        for (int value : arr1) {
            int start = 0;
            int end = arr2.length - 1;
            boolean flag = true;
            while (end - start >= 0) {
                int middle = (start + end) >>> 1;
                if (arr2[middle] >= value -d && arr2[middle] <= value + d) {
                    flag = false;
                    break;
                }
                if (arr2[middle] > value) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findTheDistanceValue(new int[]{-3,-3,4,-1,-10}, new int[]{7,10},12);
    }
}
