package com.one.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆排序
 * @author one
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
	private int heapSize;

	@Override
	protected void sort() {
		// 原地建堆
		heapSize = array.length;
		for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
			siftDown(i);
		}
		
		while (heapSize > 1) {
			// 交换堆顶元素和尾部元素
			swap(0, --heapSize);

			// 对0位置进行siftDown（恢复堆的性质）
			siftDown(0);
		}
	}
	
	private void siftDown(int index) {
		T element = array[index];
		
		int half = heapSize >> 1;
		while (index < half) { // index必须是非叶子节点
			// 默认是左边跟父节点比
			int childIndex = (index << 1) + 1;
			T child = array[childIndex];
			
			int rightIndex = childIndex + 1;
			// 右子节点比左子节点大
			if (rightIndex < heapSize && 
					cmp(array[rightIndex], child) > 0) { 
				child = array[childIndex = rightIndex];
			}
			
			// 大于等于子节点
			if (cmp(element, child) >= 0) break;
			
			array[index] = child;
			index = childIndex;
		}
		array[index] = element;
	}

	public static void main(String[] args) {
		int[] array = new int[]{10,9,6,30,5,11};

		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i : array) {
			queue.offer(i);
		}
		int index = array.length;
		while (!queue.isEmpty()) {
			array[--index] = queue.poll();
		}

		System.out.println(Arrays.toString(array));
	}
}
