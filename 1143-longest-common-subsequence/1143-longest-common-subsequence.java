class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int r = s1.length() + 1;
		int c = s2.length() + 1;
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i < r; i ++)
			for (int j = 1; j < c; j ++) {
				if (s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max (dp[i][j-1], dp[i-1][j]);
			}

		return dp[r - 1][c - 1];
    }
}