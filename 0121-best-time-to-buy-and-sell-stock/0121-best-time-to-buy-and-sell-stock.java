class Solution {
    public int maxProfit(int[] nums) {
        int minSoFar = nums[0];
        int maxProfit = 0;
        int profit;

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			minSoFar = Math.min(minSoFar, num);
			profit = num - minSoFar;
			maxProfit = Math.max(maxProfit, profit);
		}

        return maxProfit;
    }
}