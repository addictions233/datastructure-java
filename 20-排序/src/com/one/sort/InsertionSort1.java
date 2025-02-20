package com.one.sort;

/**
 * 插入排序
 * @author one
 * @param <T>
 */
public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// 从index=1开始
		for (int begin = 1; begin < array.length; begin++) {
			int cur = begin;
			while (cur > 0 && cmp(cur, cur - 1) < 0) {
				// 交换两个位置元素
				swap(cur, cur - 1);
				cur--;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{10, 8, 7,9,2,11};
		for (int begin = 1; begin < arr.length; begin++) {
			int cur = begin;
			while (cur > 0 && arr[cur] < arr[cur-1]) {
				int temp = arr[cur];
				arr[cur] = arr[cur-1];
				arr[cur-1] = temp;
				cur--;
			}
		}
		System.out.println(arr);
	}

}
