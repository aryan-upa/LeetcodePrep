class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		generateSubsets(nums, 0, new ArrayList<>(), output);
		return output;
	}

	public void generateSubsets(int[] nums, int k, ArrayList<Integer> res, List<List<Integer>> output) {
		output.add(List.copyOf(res));
		for (int i = k; i < nums.length; i ++) {
			res.add(nums[i]);
			generateSubsets(nums, i + 1, res, output);
			res.remove(res.size() - 1);
		}
	}

}