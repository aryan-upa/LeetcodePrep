class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i ++) {
			long a = nums[i];
			for (int j = i + 1; j < nums.length - 2; j ++) {
				long b = nums[j];
				int l = j + 1;
				int h = nums.length - 1;
				while (l < h) {
					long thisSum = (a + b + nums[l] + nums[h]);
					if (thisSum == target) {
						List<Integer> val = new ArrayList<>();
						val.add(nums[i]);
						val.add(nums[j]);
						val.add(nums[l]);
						val.add(nums[h]);
						set.add(val);

						l ++;
						h --;
					}
					else if (thisSum < target)
						l ++;
					else
						h --;
				}
			}
		}

		return new ArrayList<>(set.stream().toList());
	}
}