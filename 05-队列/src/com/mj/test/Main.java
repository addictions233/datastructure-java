package com.mj.test;


import com.mj.queuebystack.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enQueue(11);
		queue.enQueue(22);
		int num = queue.deQueue();
		System.out.println("num="+num);  // 11
		queue.enQueue(33);
		queue.enQueue(44);
		System.out.println(queue.Size()); // 3
		System.out.println(queue.isEmpty());// false
		System.out.println(queue.front()); //22
		while(!queue.isEmpty()) {
			System.out.println(queue.deQueue());  // 22 33 44
		}
		System.out.println(queue.isEmpty()); // true 
		
	}

}
