package com.one.array;

/**
 * @description: 二维数组
 * @author: wanjunjie
 * @date: 2025/01/06
 */
public class TwoDimensionalArray {
    public static void main(String[] args) {
        // 声明一个具有3行4列的二维数组, 但是没有初始化
        int[][] array1 = new int[3][4];

        // 声明并初始化一个具有3行4列的二维数组
        int[][] array2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        // 遍历二维数组
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.println(array2[i][j]);
            }
        }
    }
}
