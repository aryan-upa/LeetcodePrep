import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		// trying the O(n) approach

		Hashtable<Integer, Boolean> table = new Hashtable<>();
		for(int i = 0; i < nums.length; i ++)
			table.putIfAbsent(i + 1, false);

		for (int num : nums) 
			table.put(num, true);
		
		List<Integer> res = new ArrayList<>();
		
		for (int key : table.keySet())
			if (!table.get(key))
				res.add(key);
		
		return res;
    }
}