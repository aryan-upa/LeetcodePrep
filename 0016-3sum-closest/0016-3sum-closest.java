class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int minDif = Integer.MAX_VALUE;
		int res = 0;

		for (int i = 0; i < nums.length - 2; i ++) {

			int l = i + 1;
			int h = nums.length - 1;
			int currSum = nums[i];

			while (l < h) {
				currSum += nums[l] + nums[h];

				if (Math.abs(currSum - target) < minDif) {
					res = currSum;
					minDif = Math.abs(currSum - target);
				}

				if (currSum > target)
					h --;
				else if (currSum == target)
					return currSum;
				else
					l ++;

				currSum = nums[i];
			}
		}

		return res;
	}
}