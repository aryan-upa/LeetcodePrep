class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersection (nums1, nums2);
    }
    
    private int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> mapFreq = new HashMap<>();

		for (int i : nums1) {
			if (mapFreq.containsKey(i))
                mapFreq.put(i, mapFreq.get(i) + 1);
            else
                mapFreq.put(i, 1);
		}

		ArrayList<Integer> intersection = new ArrayList<>();
		for (int i : nums2) {
			if (mapFreq.containsKey(i) && mapFreq.get(i) > 0) {
				intersection.add(i);
				mapFreq.put(i, mapFreq.get(i) - 1);
			}
		}
		
		int[] res = new int[intersection.size()];
		for (int i = 0; i < res.length; i ++)
			res[i] = intersection.get(i);
		
		return res;
	}
}