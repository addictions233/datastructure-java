package com.one.array.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: wanjunjie
 * @date: 2025/02/21
 */
public class ListUtil {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer[] array = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));

        List<Integer> list2 = Arrays.asList(array);
        System.out.println(list2);
    }
}
