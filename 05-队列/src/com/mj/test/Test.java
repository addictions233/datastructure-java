package com.mj.test;


import com.mj.queue.Queue;
import com.mj.bean.Person;

public class Test {

	public static void main(String[] args) {
		Queue<Person> queue = new Queue<Person>();
		queue.enQueue(new Person("张三", 23));
		queue.enQueue(new Person("李四", 24));
		queue.enQueue(new Person("王五", 25));
		queue.enQueue(new Person("赵六", 26));
		
		System.out.println(queue.size());  //4
		System.out.println(queue.isEmpty());  // false
		System.out.println(queue.front());  //  Person:[name=张三,age=23]
		
		  while(queue.size()>0) { 
			  System.out.println(queue.deQueue()); 
		  }
		 
		
//		for (int i = 0; i < queue.size(); i++) {   //这种方法遍历队列进行出栈是错误的,因为queue.size()是随着队列元素出栈而变化,而且i又在自增
//			System.out.println(queue.deQueue());
//		}
		  
//		  for (int i = queue.size(); i >0; i--) {  // 如果想用for循环遍历队列元素进行出栈,可以用逆序
//			  System.out.println(queue.deQueue());
//		}

		System.out.println(queue.isEmpty()); //true 
	}

}
