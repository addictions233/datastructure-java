package com.one.backtracking;

/**
 * @author one
 * @description 使用回溯+剪枝处理N皇后的问题
 * @date 2023-1-1
 */
public class NQueens {
    public static void main(String[] args) {
        new NQueens().placeQueens(8);
    }

    /**
     * 数组索引是行号,数组的元素值是摆放列号
     */
    private int[] columns;

    private void placeQueens(int n) {
        columns = new int[n]; // n皇后需要记录n个摆放位置
        // 使用递归进行摆放,从第0行开始摆放皇后
        place(0);
    }

    /**
     * 从第row行开始摆放皇后
     * @param row 行号
     */
    private void place(int row) {
        if (row > 8) {
            return;
        }
        for (int col = 0; col < columns.length; col++) {
            if (isValid(row, col)) {
                // 摆放皇后
                columns[row] = col;
                place(row + 1);
            } else {
                // 减枝, 啥都不干就是剪枝
            }
        }
    }

    /**
     * 判断第row行, 第col列能否摆放皇后
     *
     * @param row 行号
     * @param col 列号
     * @return boolean
     */
    private boolean isValid(int row, int col) {
        return false;
    }


}
