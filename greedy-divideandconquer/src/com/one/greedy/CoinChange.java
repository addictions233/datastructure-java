package com.one.greedy;

import java.util.Arrays;

/**
 * @author one
 * @description 选硬币
 * @date 2024-11-12
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] faces = {25, 5, 10, 1};
        Arrays.sort(faces);

        int money = 41, coins = 0;
        for (int i = faces.length - 1; i >= 0; i--) {
            if (money < faces[i]) {
                continue;
            }
            money -= faces[i];
            coins++;
            System.out.println(faces[i]);
            i = faces.length;
        }

        System.out.println("一共选了" + coins + "枚硬币");
    }
}
