package com.one.test;

import com.one.set.ListSet;
import com.one.set.Set;

import java.util.TreeSet;

/**
 * @ClassName: ListSetTest
 * @Description: TODO
 * @Author: one
 * @Date: 2022/05/10
 */
public class ListSetTest {
    public static void main(String[] args) {
        Set<Integer> listSet = new ListSet<>();
        listSet.add(1);
        listSet.add(2);
        listSet.add(3);
        listSet.add(2);
        listSet.add(3);
        listSet.add(5);
        listSet.traversal(new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });

    }
}
