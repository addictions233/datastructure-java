package com.one.test;

import com.one.sort.BubbleSort;
import com.one.tools.Integers;
import com.one.tools.Times;

/**
 * @ClassName: Main
 * @Description: 测试类
 * @Author: one
 * @Date: 2022/05/05
 */
public class Main {
    public static void main(String[] args) {
        Integer[] random = Integers.random(1000, 1, 1000);
        Integers.println(random);
        Times.test("冒泡排序",() -> {
            Integer[] sort = BubbleSort.sort(random);
        });
    }
}
