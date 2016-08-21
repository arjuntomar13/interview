package com.test.dp;

public class EditDistance {

	static int findWithRec(String s1, String s2, int m, int n){
		
		if(m == 0){
			return n;
		}
		if(n == 0){
			return m;
		}
		
		if(s1.charAt(m-1) == s2.charAt(n-1)){
			return findWithRec(s1, s2, m-1, n-1);
		}
		
		return 1 + min(findWithRec(s1, s2, m, n-1), findWithRec(s1, s2, m-1, n), findWithRec(s1, s2, m-1, n-1));
	}
	
	static int min(int x, int y, int z){
		if(x < y && x < z){
			return x;
		}
		if(y < x && y < z){
			return y;
		}else{
			return z;
		}
	}
	
	static int findWithDP(String s1, String s2, int m, int n){
		int[][] dp = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if(i == 0)
					dp[i][j] = j;
				else if(j == 0)
					dp[i][j] = i;
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		String s1 = "geekarjuntomarart";
		String s2 = "gesektomararjgyu";
		System.out.println("With recursion start: " + System.currentTimeMillis());
		System.out.println(findWithRec(s1, s2, s1.length(), s2.length()));
		System.out.println("With recursion ends: " + System.currentTimeMillis());
		System.out.println("With DP start: " + System.currentTimeMillis());
		System.out.println(findWithDP(s1, s2, s1.length(), s2.length()));
		System.out.println("With DP ends: " + System.currentTimeMillis());
	}
}
