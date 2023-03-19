class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersection (nums1, nums2);
    }
    
    private int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> mapFreq = new HashMap<>();

		for (int idx = 0; idx < nums1.length; idx ++) {
            int i = nums1[idx];
			int v = mapFreq.computeIfAbsent(i, val -> 0);
            mapFreq.put(i, v + 1);
		}

		ArrayList<Integer> intersection = new ArrayList<>();
		for (int idx = 0; idx < nums2.length; idx ++) {
            int i = nums2[idx];
            int fq = mapFreq.getOrDefault(i, 0);
			if (fq > 0) {
				intersection.add(i);
				mapFreq.put(i, fq - 1);
			}
		}
		
		int[] res = new int[intersection.size()];
		for (int i = 0; i < res.length; i ++)
			res[i] = intersection.get(i);
		
		return res;
	}
}