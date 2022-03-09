package com.mj.test;


import com.mj.bean.Person;
import com.mj.printer.BinaryTrees;
import com.mj.tree.BinarySearchTree2;

public class Main2 {

	public static void main(String[] args) {
		method1();
		
//		method2();
		
		
		
	}

	private static void method2() {
		BinarySearchTree2<Person> bst = new BinarySearchTree2<Person>();
		bst.add(new Person("王五",25));
		bst.add(new Person("赵六",26));
		bst.add(new Person("张三",23));
		bst.add(new Person("马七",27));
		bst.add(new Person("李四",24));
		
		BinaryTrees.println(bst);
	}

	private static void method1() {
		BinarySearchTree2<Integer> bst = new BinarySearchTree2<Integer>();
		int[] arr = {7,4,9,2,5,8,11,3,12,1};
		for (int i : arr) {
			bst.add(i);
		}
		
		BinaryTrees.println(bst);
//		bst.preorderTraversal();
		bst.levelOrderTraversal();
	}

}
