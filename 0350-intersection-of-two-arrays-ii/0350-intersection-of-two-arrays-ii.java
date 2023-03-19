class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersection (nums1, nums2);
    }
    
    private int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> mapFreq = new HashMap<>();

		for (int i : nums1) {
			int v = mapFreq.computeIfAbsent(i, val -> 0);
            mapFreq.put(i, v + 1);
		}

		ArrayList<Integer> intersection = new ArrayList<>();
		for (int i : nums2) {
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