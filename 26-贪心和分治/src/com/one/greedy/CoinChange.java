package com.one.greedy;

import java.util.Arrays;

/**
 * @author one
 * @description 选硬币
 * 假设有 25 分、20/10 分、5 分、1 分的硬币，现要找给客户 41 分的零钱，如何办到硬币个数最少？
 * ◼ 贪心策略：每一步都优先选择面值最大的硬币
 * ① 选择 25 分的硬币，剩 16 分
 * ② 选择 5 分的硬币，剩 11 分
 * ③ 选择 5 分的硬币，剩 6 分
 * ④ 选择 5 分的硬币，剩 1 分
 * ⑤ 选择 1 分的硬币
 * 最终的解是 1 枚 25 分、3 枚 5 分、1 枚 1 分的硬币，共 5 枚硬币
 * ◼ 实际上本题的最优解是：2 枚 20 分、1 枚 1 分的硬币，共 3 枚硬币
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
