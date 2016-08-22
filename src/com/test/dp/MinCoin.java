package com.test.dp;

public class MinCoin {

	static int getMinCoin(int[] coins, int val) {

		int[] dp = new int[val + 1];
		int[] res = new int[val + 1];

		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE-1;
			res[i] = -1;
		}

		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(j - coins[i] >= 0){
					if(dp[j] > 1 + dp[j - coins[i]]){
						dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
						res[j] = i;
					}
				}
			}
		}
		
		System.out.println("Minimum number of coins required : " + dp[val]);
		System.out.println("The coins required are below : ");
		int j = val;
		while(j != 0){
			System.out.println(coins[res[j]] + " ");
			j = j - coins[res[j]];
		}

		return dp[val];
	}

	public static void main(String[] args) {
		int val = 150;
		int[] coins = { 5, 3, 8, 2, 11 };
		getMinCoin(coins, val);
	}
}