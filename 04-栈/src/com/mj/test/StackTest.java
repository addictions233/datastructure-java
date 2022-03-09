package com.mj.test;

import com.mj.stack.Stack;

import java.util.Scanner;




/**
 * 	用栈stack 数组结构来模拟网页的前进和后退
 * @author one
 *
 */
public class StackTest {
	private static Stack<String> mainStack =  new Stack<String> ();  // 主栈
	static {
		mainStack.push("www.baidu.com");
		mainStack.push("www.qq.com");
		mainStack.push("www.jingdong.com");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> viceStack =  new Stack<String> ();  // 副栈
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("请输入你想要的操作:");
			String str = sc.nextLine();
			if(str.equals("后退")) {
				String str2 = mainStack.pop();
				viceStack.push(str2);
				System.out.println(str2);
			} else if(str.equals("前进")) {
				String str3 = viceStack.pop();
				mainStack.push(str3);
				System.out.println(str3);
			} else {
				return;
			}
		}
	}

}
