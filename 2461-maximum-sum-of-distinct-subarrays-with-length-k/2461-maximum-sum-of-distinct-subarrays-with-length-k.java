class Solution {
	public long maximumSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		long maxSum = 0;
		long lSum = 0;
		for (int i = 0; i < k; i ++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			lSum += nums[i];
		}

		if (map.keySet().size() == k)
			maxSum = maxSum < lSum ? lSum : maxSum;
		
		int l = 0;
		int h = k;
		
		while (h < nums.length) {
			map.put(nums[h], map.getOrDefault(nums[h], 0) + 1);
			map.put(nums[l], map.get(nums[l]) - 1);
			
			if (map.get(nums[l]) == 0)
				map.remove(nums[l]);
			
			lSum += nums[h] - nums[l];

			if (map.keySet().size() == k)
				maxSum = maxSum < lSum ? lSum : maxSum;
			
            l ++;
			h ++;
		}
		
		return maxSum;
	}
}