class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
		int[][] dp = new int[nums1.length][nums2.length];
		for (int[] a : dp)
			Arrays.fill(a, -1000_000_00);
		return findProductDP(nums1, nums2, 0, 0, false, dp);
    }

	public static int findProductDP (int[] nums1, int[] nums2, int i, int j, boolean flag, int[][] dp) {
		if (i == nums1.length || j == nums2.length)
			return flag ? 0 : -1000000;

		if (dp[i][j] != -1000_000_00)
			return dp[i][j];

		int dotProduct = nums1[i] * nums2[j] + findProductDP(nums1, nums2, i + 1, j + 1, true, dp);

		int firstRem = findProductDP (nums1, nums2, i + 1, j, false, dp);
		int secondRem = findProductDP (nums1, nums2, i, j + 1, false, dp);

		return dp[i][j] = Math.max(nums1[i] * nums2[j], Math.max(dotProduct, Math.max(firstRem, secondRem)));
	}
}