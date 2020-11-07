package com.mj;

import java.util.Comparator;

import com.mj.BinarySearchTree.Visitor;
import com.mj.bean.Person;
import com.mj.printer.BinaryTrees;

public class Main{
	public static void main(String[] args) {
//		method1();
//		method2();
		BinarySearchTree<Integer> bst3 = new BinarySearchTree<Integer>();
		int[] arr = {7,4,9,2,5,8,11,3,12,1,10};
		for (int e : arr) {
			bst3.add(e);
		}
		//直接在控制台打印此二叉搜索树
		BinaryTrees.print(bst3);
		System.out.println("\n");
		//调用前序遍历的方法
//		bst3.preorderTraversal();
		
		//调用中序遍历方法
//		bst3.inorderTraversal();
		
		//调用层序遍历的方法
//		bst3.levelOrderTraversal();
		bst3.levelorderTraversal(new Visitor<Integer>() {
			@Override
			public boolean visit(Integer e) {
				System.out.println(e);
				return e==2? true:false;
			}
		});	
	}

	private static void method2() {
		//创建一个存储Person对象,带比较器的二叉搜索树
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getAge()-o2.getAge();
			}
		});
		bst2.add(new Person("王五",25));
		bst2.add(new Person("李四",24));
		bst2.add(new Person("赵六",26));
//		bis2.add(new Person("张三",23));
		bst2.add(new Person("马七",23));
		
		BinaryTrees.println(bst2);
	}

	private static void method1() {
		//创建一个存储整数的二叉搜索树,Integer已经实现了Comparable接口
		BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
		Integer[] array = new Integer[] {7,4,8,10,43,1,25};
		for (Integer integer : array) {
			bst1.add(integer);
		}
		bst1.add(3);
		bst1.add(123);
		//在控制台打印二叉树
		BinaryTrees.println(bst1);
	}

	

}
