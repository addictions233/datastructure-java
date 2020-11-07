package com.mj;

import java.util.ArrayList;

import com.mj.bean.Person;

/**
 * 	测试类:
 * 	在ArrayList集合中存储Person类对象,检测ArrayList集合是否正确
 * 
 * @author one
 *
 */
public class Main {
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三", 23)); // 测试 add(E element)方法
//		list.remove(0);
		System.out.println(list);
		list.add(new Person("李四", 24));
		list.add(new Person("王五", 25));
//		System.out.println(list);
		list.add(1, new Person("赵六", 26)); // 测试 add(int index , E element)方法
		System.out.println(list);
		/*
		 * list.clear(); //提醒系统启动垃圾回收机制 System.gc(); System.out.println(list); //测试clear()方法
		 */
		System.out.println(list.size());  //测试size()方法
		/*
		 * System.out.println(list.isEmpty()); list.clear(); //测试 isEmpty()方法
		 * System.out.println(list.isEmpty());
		 */
		System.out.println(list.indexOf(new Person("赵六", 26))); //测试 indexOf()方法
		
//		list.remove(4);       //测试remove(int index) 方法  rangeCheck(int index)方法
//		list.add(5,new Person("马七",27));  //测试 rangeCheckForAdd(int index)方法
//		System.out.println(list);
		
		list.add(new Person("张三", 23));
		list.add(new Person("张三", 23));
		list.add(new Person("张三", 23));
		list.add(new Person("张三", 23));
		list.add(new Person("张三", 23));
		System.out.println(list);
		System.out.println(list.size());
		
		java.util.ArrayList<Person> list2  = new ArrayList<Person>();

	}

}
