import java.util.Hashtable;

class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Hashtable <Integer, Integer> table = new Hashtable<>();

		int l = 0;
		int h = 0;

		for (int i = 0; i <= k && i < nums.length; i ++) {
            
            Integer val = table.get(nums[i]);
            
			if (val == null)
				table.put(nums[i], 1);
			else
				table.put(nums[i], val + 1);

            if (table.get(nums[i]) == 2)
				return true;
		}

		h = k + 1;

		while (h < nums.length) {
			table.put(nums[l], table.get(nums[l]) - 1);

            Integer val = table.get(nums[h]);
            
			if (val == null)
				table.put(nums[h], 1);
			else
				table.put(nums[h], val + 1);

			if (table.get(nums[h]) == 2)
				return true;

			l ++;
			h ++;
		}

		return false;
	}
}