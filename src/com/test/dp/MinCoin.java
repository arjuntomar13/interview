package com.test.dp;

public class MinCoin {
	
	public static void main(String[] args) {
		int n = 8;
		int m = 3;
		int[] S = {1,3,5};
		int[] table = new int[n+1];
		
		table[0] = 1;
		
		for(int i=0; i<m; i++)
	        for(int j=S[i]; j<=n; j++)
	            table[j] += table[j-S[i]];
		
	    System.out.println(table[n]);
	}
}