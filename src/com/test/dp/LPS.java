package com.test.dp;

//Longest Palindromic subsequence
public class LPS {

	void findLongestPalindromic(String s) {

		int len = s.length();
		int[][] lps = new int[len][len];

		for (int i = 0; i < len; i++) {
			lps[i][i] = 1;
		}

		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				lps[i][i + 1] = 2;
			} else {
				lps[i][i + 1] = 1;
			}
		}
		int j = 0;
		for (int k = 2; k < len; k++) {
			for (int i = 0; i < len - k ; i++) {
				j = i + k;
				if (s.charAt(i) == s.charAt(j)) {
					lps[i][j] = 2 + lps[i+1][j-1];
				} else {
					lps[i][j] = Math.max(lps[i][j - 1], lps[i + 1][j]);
				}
			}
		}

		System.out.println("max sub sequence length is : " + lps[0][len - 1]);
	}

	public static void main(String[] args) {
		String str = "cdekkecd";
		LPS lps = new LPS();
		lps.findLongestPalindromic(str);
	}
}
