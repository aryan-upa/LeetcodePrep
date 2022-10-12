class Solution {
	public int largestPerimeter(int[] nums) {
		Arrays.sort(nums);

        int iniPos = nums.length - 3;
		while (iniPos >= 0) {
			if (nums[iniPos + 2] < (nums[iniPos + 1] + nums[iniPos]))
				return nums[iniPos] + nums[iniPos + 1] + nums[iniPos + 2];
			iniPos--;
		}

		return 0;
	}
}