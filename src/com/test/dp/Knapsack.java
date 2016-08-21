package com.test.dp;

public class Knapsack {

	static int knapSack(int W,int[] wt,int[] val,int n){
		
		int[][] dp = new int[n][W+1];
		
		for(int i = 0; i < n ; i++){
			for(int j =0; j <= W ; j++){
				
				if(i == 0){
					if(j < wt[0]){
						dp[i][j] = 0;
					}else{
						dp[i][j] = val[i];
					}
				}else if(j == 0){
					dp[i][j] = 0;
				}else if(j < wt[i]){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = Math.max(val[i] + dp[i-1][j - wt[i]], dp[i-1][j]);
				}
			}
		}
		int i = n-1, j = W;
		
		while(i > 0 && j > 0){
			if(dp[i-1][j] != dp[i][j]){
				System.out.println(wt[i] + " ");
				j = j - wt[i];
				i--;
				if(i == 0){
					System.out.println(wt[i]);
				}
			}else{
				i--;
				if(i == 0){
					System.out.println(wt[i]);
				}
			}
		}
		
		return dp[n-1][W];
	}
	
	public static void main(String[] args) {
	    int val[] = new int[]{60, 100, 2, 44, 200};
	    int wt[] = new int[]{1, 2, 3, 12, 34};
	    int  W = 50;
	    int n = val.length;
	    System.out.println("The max value which can be kept in knapsack is : " + knapSack(W, wt, val, n));
	}
}