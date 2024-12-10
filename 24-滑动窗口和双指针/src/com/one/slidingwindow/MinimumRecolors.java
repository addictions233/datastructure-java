package com.one.slidingwindow;

/**
 * @description: 2379. 得到 K 个黑块的最少涂色次数
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。
 * 字符 'W' 和 'B' 分别表示白色和黑色。
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数
 * @author: wanjunjie
 * @date: 2024/12/10
 */
public class MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int result = Integer.MAX_VALUE;
        int black = 0;
        char[] chars = blocks.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 1. 初始化窗口
            if (i < k -1) {
                if (chars[i] == 'B') {
                    black++;
                }
                continue;
            }
            // 2. 进入窗口
            if (chars[i] == 'B') {
                black++;
            }

            // 3. 计算结果
            result = Math.min(result, k-black);
            // 4. 出窗口
            if (chars[i-k+1] == 'B') {
                black--;
            }
        }
        return result;
    }
}
