package com.test.stack;

import java.util.Scanner;
import java.util.Stack;

public class Waiter {

	private static int[] primeArray;
	
	public void preparePrimeNumberArray(int numberOfIterations){
		
		int count = 1;
		primeArray = new int[numberOfIterations];
		primeArray[0] = 2;
		int n= 3;
		
		while(count != numberOfIterations){
			if(isPrime(n)){
				primeArray[count] = n;
				count++;
			}
			n += 2;
		}
	}
	
	public void orderPlates(Stack<Integer> stack, int numberOfIterations){
		
		while(stack.empty()){
			
		}
	}
	
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		int totalNumberOfPlates = Integer.parseInt(console.next());
		int numberOfIterations = Integer.parseInt(console.next());
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i< totalNumberOfPlates; i++){
			stack.push(Integer.parseInt(console.next()));
		}
		
		Waiter waiter = new Waiter();
		waiter.preparePrimeNumberArray(numberOfIterations);
		
		waiter.orderPlates(stack, numberOfIterations);
		
	}
	
	
	boolean isPrime(int n) {
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}