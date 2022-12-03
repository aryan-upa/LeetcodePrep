import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		// trying the O(n) approach
		boolean[] table = new boolean[nums.length + 1];
			
		for (int num : nums)
			table[num] = true;
			
		List<Integer> res = new ArrayList<>();

		for (int i = 1; i < table.length; i ++)
			if (!table[i])
				res.add(i);
		
		return res;

    }
}