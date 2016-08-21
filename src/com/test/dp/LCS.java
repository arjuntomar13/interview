package com.test.dp;

public class LCS {

	public static void main(String[] args) {
		String a = "ABCDGHB";
		String b = "AEDFHRA";

		int m = a.length();
		int n = b.length();
		int[][] opt = new int[m + 1][n + 1];

		// compute length of LCS and all subproblems via dynamic programming
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (a.charAt(i) == b.charAt(j))
					opt[i][j] = opt[i + 1][j + 1] + 1;
				else
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
			}
		}
		System.out.println("LCS length : " + opt[0][0]);

		// recover LCS and print it
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (a.charAt(i) == b.charAt(j)) {
				System.out.print(a.charAt(i));
				i++;
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1])
				i++;
			else
				j++;
		}
	}
}