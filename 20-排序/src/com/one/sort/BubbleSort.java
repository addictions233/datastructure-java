package com.one.sort;

import java.util.Arrays;

/**
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Author: one
 * @Date: 2022/05/05
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 23, 423, 28, 23, 4902, 29, 9, 23, 47};

        // 第一轮比到最后一个数字,第二轮比到倒数第二个数字... 最后一轮比较1,2位数字
        for (int end = array.length - 1; end > 0; end--) {
            // 每一轮都是从第一个数字开始比起,找到最大的数字
            boolean flag = true; // 优化冒泡排序,如果已经排好序,终止冒泡过程
            for (int i = 1; i <= end; i++) {
                if (array[i] < array[i-1]) { // 当前后数字比后面大时才调换位置
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static Integer[] sort(Integer[] source) {
        // 第一轮比到最后一个数字,第二轮比到倒数第二个数字... 最后一轮比较1,2位数字
        for (int end = source.length - 1; end > 0; end--) {
            // 每一轮都是从第一个数字开始比起,找到最大的数字
            boolean flag = true; // 优化冒泡排序,如果已经排好序,终止冒泡过程
            for (int i = 1; i <= end; i++) {
                if (source[i] < source[i-1]) { // 当前后数字比后面大时才调换位置
                    int temp = source[i];
                    source[i] = source[i-1];
                    source[i-1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return source;
    }
}
