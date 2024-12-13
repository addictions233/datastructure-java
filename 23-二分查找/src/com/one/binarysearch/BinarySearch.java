package com.one.binarysearch;

/**
 * @description: 二分查找最基本写法
 * @author: wanjunjie
 * @date: 2024/12/13
 */
public class BinarySearch {

    /**
     * 使用while循环写二分查找 (区别于递归写法)
     */
    public static int binarySearch(int[] arr, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            // 无符合右移
            int middle = (low + high) >>> 1;
            if (arr[middle] < key) {
                low = middle + 1;
            } else if (arr[middle] > key) {
                high = middle -1;
            } else {
                return middle;
            }
        }
        return -(low  + 1);
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,3,5,7,9},0, 5,4));
    }
}
