package com.one.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author one
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		
//		for (int end = array.length - 1; end > 0; end--) {
//			int max = 0;
//			for (int begin = 1; begin <= end; begin++) {
//				if (cmp(max, begin) <= 0) {
//					max = begin;
//				}
//			}
//			swap(max, end);
//		}
		
		for (int end = array.length - 1; end > 0; end--) {
			int max = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (cmp(max, begin) < 0) {
					max = begin;
				}
			}
			swap(max, end);
		}
		
		// 7 5 10 1 4 2 10 
	}

	public static void main(String[] args) {
		int[] array = new int[]{10,9,6,30,5,11};
		for (int end = array.length - 1; end > 0; end--) {
			int maxIndex = 0;
			for (int i = 0; i <= end; i++) {
				if (array[maxIndex] < array[i]) {
					maxIndex = i;
				}
			}
			int tem= array[maxIndex];
			array[maxIndex] = array[end];
			array[end] = tem;
		}
		System.out.println(Arrays.toString(array));
	}

}
