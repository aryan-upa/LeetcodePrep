class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {
		int[] mods = new int[nums.length + 1];

		mods[0] = 0;
		mods[1] = nums[0] % k;

		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();

        set.add(0);
        map.put(0, 0);

        for (int i = 0; i < nums.length; i ++) {
			mods[i+1] = (mods[i] + nums[i]) % k;
			if (!set.contains(mods[i+1])) {
				set.add(mods[i + 1]);
				map.put(mods[i + 1], i + 1);
			}
			else {
				if ((i + 1) - map.get(mods[i + 1]) >= 2)
					return true;
			}
		}

		return false;
	}
}