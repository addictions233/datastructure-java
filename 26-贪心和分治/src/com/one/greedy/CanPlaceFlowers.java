package com.one.greedy;

/**
 * @description: 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？
 * 能则返回 true ，不能则返回 false 。
 * @author: wanjunjie
 * @date: 2024/12/05
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            int previous = i == 0 ? 0 : flowerbed[i -1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i +1];
            if (previous == 0 && flowerbed[i] == 0 && next == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }
}
