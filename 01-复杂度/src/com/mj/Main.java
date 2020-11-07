package com.mj;

import com.mj.Times.Task;

/** 
 * 	计算斐波那契数列:  
 * 		0,1,1,2,3,5,8....
 *	 		计算第n个斐波那契数,两种方法 :  1,递归  2, 迭代
 */
public class Main {
	public static void main(String[] args) {
//		System.out.println(fib2(0));
//		System.out.println(fib2(1));
//		System.out.println(fib2(2));
//		System.out.println(fib2(3));
//		System.out.println(fib2(4));
//		System.out.println(fib2(40));
		Times.test("fib(35)", new Task() {
			
			@Override
			public void execute() {
				fib(45);
				
			}
		});
		Times.test("fib2(35)", new Task() {
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				fib2(4);
				
			}
		});
		
	}
	public static  int fib(int n) {
		if (n<=1) {
			return n;
		}
	 return fib(n-1)+fib(n-2);
	}
	
	public static int fib2(int n) {
		if(n<=1) {
			return n;
		} else {
			int first = fib2(0);
			int second = fib2(1);
		for (int i=0;i<n-1;i++) {
			int sum = first+second;
			first =second;
			second =sum;	
		}
		return second;
		}
	}
}
