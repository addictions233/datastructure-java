package com.mj;

/**
 * 	测试  栈stack类
 * @author one
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		//打印栈中存储的元素个数
		System.out.println(stack.size()); // 输出: 4
		
		//判断栈是否为空
		System.out.println(stack.isEmpty()); //输出: false
		
		//查询栈顶元素
		System.out.println(stack.top()); // 输出: four
		
		while(stack.size()>0) {
			System.out.println(stack.pop()); // 输出: four three two one
			
		/**
		 * 	查看java源码中写的栈结构 java.util.Stack
		 */
			
			java.util.Stack<Integer> juStack;
		}
	}

}
