package com.one.sort;

/**
 * @description: 手写快速排序
 * @author: wanjunjie
 * @date: 2025/02/25
 */
public class QuickSort2<T extends Comparable<T>> extends Sort<T>{
    @Override
    protected void sort() {

    }

    /**
     * 对[begin,end)区间的元素进行排序, 左闭右开
     */
    private void sort(int begin, int end) {
        if (end - begin <= 1) {
            return;
        }
        // 确定轴点的位置
        int mid = pivotIndex(begin, end);
        // 对子序列进行快速排序
        sort(begin, mid);
        sort(mid+1, end);
    }

    private int pivotIndex(int begin, int end) {
        // 使用第一个元素作为轴点元素值
        T pivot = array[begin];
        // end指向最后一个元素
        end--;
        while (begin < end){
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) {
                    end--;
                } else {
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        // 设置轴点位置
        array[begin] = pivot;
        return begin;
    }
}
