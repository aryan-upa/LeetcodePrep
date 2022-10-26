class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;

        Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();

        set.add(0);
        map.put(0, 0);

        for (int i = 0; i < nums.length; i ++) {
			sum += nums[i];
            int val = sum % k;
			if (!set.contains(val)) {
				set.add(val);
				map.put(val, i + 1);
			}
			else {
				if ((i + 1) - map.get(val) >= 2)
					return true;
			}
		}

		return false;
	}
}