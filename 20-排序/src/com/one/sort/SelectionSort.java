package com.one.sort;

import com.one.tools.Integers;

import java.util.Arrays;

/**
 * @author one
 * @description 选择排序
 * @date 2022-8-10
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] random = Integers.random(10, 1, 10);
        System.out.println(Arrays.toString(random));
        Integer[] target = selectSort(random);
        System.out.println(Arrays.toString(target));
    }

    /**
     * 遍历一轮,找到这一轮最大的元素,然后放在队列最后
     *
     * @param source
     * @return
     */
    public static Integer[] selectSort(Integer[] source) {
        // 总共要遍历length-1轮
        for (int length = source.length - 1; length > 0; length--) {
            int maxIndex = 0; // 记录最大的索引位置
            for (int i = 1; i <= length; i++) {
                if (source[maxIndex] < source[i]) {
                    maxIndex = i;
                }
            }
            // 将最大值和末尾元素交换位置
            int temp = source[maxIndex];
            source[maxIndex] = source[length];
            source[length] = temp;
        }
        return source;
    }
}
