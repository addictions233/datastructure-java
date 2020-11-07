package com.mj;
/**
 * 	数组的冒泡排序方法
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {11,33,22,55,99,66,77,88,44};
		for (int i = 0; i < array.length; i++) {  //时间复杂度o(n*(n+1)/2)   o(n^2)
			for (int j = 1; j < array.length-i; j++) {
				int x;
				if(array[j-1]>array[j]) {
					x = array[j-1];
					array[j-1] = array[j];
					array[j] = x;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
	}

}
