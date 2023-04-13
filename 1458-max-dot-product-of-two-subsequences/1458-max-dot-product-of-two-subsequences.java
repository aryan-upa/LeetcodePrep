class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        return findProductTD(nums1, nums2);
    }

	public static int findProductTD (int[] nums1, int[] nums2) {
		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		int specialCase = Integer.MIN_VALUE;

		for (int i = 1; i < dp.length; i ++) {
			for (int j = 1; j < dp[0].length; j ++) {
				int dot = nums1[i-1]*nums2[j-1] + dp[i-1][j-1];
				int firstRem = dp[i-1][j];
				int secondRem = dp[i][j-1];

				specialCase = Math.max(specialCase, nums1[i-1]*nums2[j-1]);
				dp[i][j] = Math.max(dot, Math.max(firstRem, secondRem));
			}
		}
		
		if (dp[nums1.length][nums2.length] == 0)
			return specialCase;
		
		return dp[nums1.length][nums2.length];
	}
}