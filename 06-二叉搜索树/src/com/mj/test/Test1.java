package com.mj.test;

import com.mj.tree.BinarySearchTree;
import com.mj.printer.BinaryTrees;


/**
 * 练习1: 翻转一棵二叉树
 * @author one
 *
 */
public class Test1 {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		int[] arr = {7,4,9,2,5,8,11,3,12,1,10};
		for (int e : arr) {
			bst.add(e);
		}
		BinaryTrees.print(bst);
		

	}
	
//	public static <E> BinarySearchTree<E> reversal(BinarySearchTree<E> tree) {
//		
//	}
//	
	public static <E> BinarySearchTree<E> reversal2(BinarySearchTree<E> tree) {
		
		return null;
	}

}
