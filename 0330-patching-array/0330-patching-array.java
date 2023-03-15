class Solution {
	public int minPatches(int[] nums, int n) {
		long missing = 1;
		int count = 0;

		int i = 0;
		while (missing <= n) {
			if (i < nums.length && missing >= nums[i]) {
				missing += nums[i];
				i += 1;
			} else {
				count += 1;
				missing += missing;
			}
		}

		return count;
	}
}