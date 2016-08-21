package com.test.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	//Map to store the previous results
	static Map<Integer,Long> computedValues = new HashMap<Integer, Long>();

	int getFibonacci(int n){
		int first = 1;
		int second = 1;
		int current = first + second;

		for(int i =3; i <= n ; i++){
			current = first + second;
			first = second;
			second = current;
			System.out.print(current + " ");
		}
		System.out.println();
		return current;
	}

	public BigInteger fibonacciDP(int n) {
		BigInteger[] results = new BigInteger[n+1];
		results[1] = BigInteger.ONE;
		results[2] = BigInteger.ONE;
		for (int i = 3; i <= n; i++) {
			results[i] = results[i-1].add(results[i-2]);
		}
		return results[n];
	}

	public static long fibonacci(int n) {
		if (n < 3) return 1;

		//The two edge cases
		computedValues.put(1, 1L);
		computedValues.put(2, 1L);

		return fibonacci(n,computedValues);
	}

	private static long fibonacci(int n, Map<Integer, Long> computedValues) {
		if (computedValues.containsKey(n)) return computedValues.get(n);

		computedValues.put(n-1, fibonacci(n-1,computedValues));
		computedValues.put(n-2, fibonacci(n-2,computedValues));

		long newValue = computedValues.get(n-1) + computedValues.get(n-2);
		computedValues.put(n, newValue);
		return newValue;
	}

	public static Long fibonacci1(int n){
		
		if(n<3){
			return 1L;
		}
		
		Map<Integer, Long> computedMap = new HashMap<Integer, Long>();
		computedMap.put(1, 1L);
		computedMap.put(2,1L);
		
		Long fibNumber = getFib(n, computedMap);
		
		return fibNumber;
	}
	
	public static Long getFib(int n, Map<Integer, Long> computedMap){
		
		if(computedMap.containsKey(n)){
			return computedMap.get(n);
		}
		computedMap.put(n-1, getFib(n-1, computedMap));
		
		Long newValue = computedMap.get(n-1) + computedMap.get(n-2);
		
		computedMap.put(n, newValue);
		
		return newValue;
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci1(10));
	}

}
