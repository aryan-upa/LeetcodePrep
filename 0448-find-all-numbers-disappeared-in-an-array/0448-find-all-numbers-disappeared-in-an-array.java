import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		// The most optimal O(n) approach with constant space (neglecting space req for result).
        int idx;
		for (int i = 0; i < nums.length; i ++) {
            idx = nums[i] < 0 ? -nums[i] : nums[i];
			nums[idx - 1] *= nums[idx - 1] > 0 ? -1 : 1;
        }

		List<Integer> list = new ArrayList<>(nums.length);
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] > 0)
				list.add(i+1);
		
		return list;
    }
}