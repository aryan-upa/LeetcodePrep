class Solution {
	public int largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		reverseArray(nums);

		int iniPos = 0;
		while (iniPos < nums.length - 2) {
			if (isValidTriangle(nums[iniPos], nums[iniPos + 1], nums[iniPos + 2]))
				return nums[iniPos] + nums[iniPos + 1] + nums[iniPos + 2];
			iniPos++;
		}

		return 0;
	}

	public boolean isValidTriangle (int s1, int s2, int s3) {
		return s1 < s2 + s3;
	}

	public void reverseArray(int[] nums) {
		int l = 0;
		int h = nums.length - 1;

		while (l < h) {
			int temp = nums[l];
			nums[l] = nums[h];
			nums[h] = temp;
			l ++;
			h --;
		}
	}
}