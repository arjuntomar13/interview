package com.test.stack;

import java.util.Scanner;
import java.util.Stack;

public class Braces {

	public static void method1() {
		Scanner console = new Scanner(System.in);
		int arrLength = console.nextInt();
		String[] values = new String[arrLength];
		String[] returnArray = new String[arrLength];
		for (int i = 0; i < arrLength; i++) {
			Stack<Character> stack = new Stack<Character>();
			values[i] = console.next();
			String str = values[i];
			char c;
			for (int j = 0; j < str.length(); j++) {
				c = str.charAt(j);

				if (c == '(' || c == '{' || c == '[') {
					stack.push(c);
				} else if (c == ']') {
					if (stack.empty()) {
						stack.push(c);
						break;
					} else if (stack.peek() == '[') {
						stack.pop();
					}
				} else if (c == ')') {
					if (stack.empty()) {
						stack.push(c);
						break;
					} else if (stack.peek() == '(') {
						stack.pop();
					}
				} else if (c == '}') {
					if (stack.empty()) {
						stack.push(c);
						break;
					} else if (stack.peek() == '{') {
						stack.pop();
					}
				}
			}
			if(stack.empty()){
				returnArray[i] = "YES";
			}else{
				returnArray[i] = "NO";
			}
		}

		for (String result : returnArray) {
			System.out.println(result);
		}
	}

	public static void main(String[] args) {
		String[] strArr = {"()[]{}", "{[}]", "(arjun){", "{}"};
		method1();

		/*
		 * {[()]} {[(])} {{[[(())]]}}
		 */

	}
}
