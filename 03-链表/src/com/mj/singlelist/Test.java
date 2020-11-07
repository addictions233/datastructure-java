package com.mj.singlelist;

import com.mj.bean.Person;

public class Test {

	public static void main(String[] args) {
		/**
		 * LinkList没有写构造器,默认调用空参构造方法
		 */
		SingleLinkedList<Person> list = new SingleLinkedList<Person>();
		list.add(new Person("张三", 23));
		list.add(new Person("李四", 24));
		list.add(new Person("王五", 25));
		list.add(new Person("王五", 25));
		list.add(new Person("赵六", 26));
		list.add(1, new Person("马七", 27));
		list.remove(2);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.indexOf(new Person("马七", 27)));
		System.out.println(list.contains(new Person("赵六", 26)));
		
		/*
		 * list.clear(); //测试 clear()方法
		 * 
		 * //提醒系统进行垃圾回收 System.gc(); System.out.println(list.size());
		 */
		 
	}

}
