package com.one.greedy;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @description: TODO
 * @author: wanjunjie
 * @date: 2025/03/17
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] split = s1.split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        String line = sc.nextLine();
        Integer[] array = Arrays.stream(line.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        Arrays.sort(array);
        int start = 0;
        int end = n - 1;
        int sum = 0;
        while(start <= end) {
            if (array[end] + array[start] <= m) {
                start++;
                end--;
            } else {
                end--;
            }
            sum++;
        }
        System.out.println(sum);
    }
}
