package com.test.dp;

public class LPSStr {

	void findLongestPalindrome(String str){

		int startIndex = 0;
		int endIndedex = 0;
		int len = str.length();
		int[][] lps = new int[len][len];
		for(int i = 0 ; i < len ; i++){
			lps[i][i] = 1;
		}

		for(int i = 0; i < len -1 ; i++){
			if(str.charAt(i) == str.charAt(i+1)){
				lps[i][i+1] = 1;
				startIndex = i;
				endIndedex = i + 1;
			}
		}

		for(int k = 2; k < len ; k++){

			for(int i = 0; i < len - k ; i++){
				int j = i + k;
				if(str.charAt(i) == str.charAt(j)){
					if(lps[i+1][j-1] == 1){
						startIndex = i;
						endIndedex = j;
						lps[i][j] = 1;
					}
				}
			}
		}

		System.out.println("Longest palindromic substring is of length : " + (endIndedex - startIndex + 1));
		StringBuilder sb = new StringBuilder();

		for(int i = startIndex ; i <=endIndedex; i++){
			sb.append(str.charAt(i));
		}

		System.out.println("Longest palindromic substring is : " + sb.toString());
	}

	public static void main(String[] args) {
		LPSStr longestPalindrome = new LPSStr();
		String str = "cdekkecd";
		longestPalindrome.findLongestPalindrome(str);
	}
}