package com.one.greedy;

import java.util.Arrays;

/**
 * @author one
 * @description 海盗问题
 * @date 2024-11-12
 */
public class Pirate {

    public static void main(String[] args) {
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        int capacity = 30, weight = 0, count = 0;
        Arrays.sort(weights);
        for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weight + weights[i];
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
                System.out.println(weights[i]);
            }
        }
        System.out.println("一共选了" + count + "件古董");
    }
}
