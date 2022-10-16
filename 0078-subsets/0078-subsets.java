class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		generateSubsets(nums, 0, new ArrayList<>(), output);
		return output;
	}

	public void generateSubsets(int[] nums, int k, ArrayList<Integer> res, List<List<Integer>> output) {
		if (k == nums.length) {
			output.add(List.copyOf(res));
			return;
		}

		generateSubsets(nums, k +1, res, output);
		res.add(nums[k]);
		generateSubsets(nums, k + 1,  res, output);
		res.remove(res.size() - 1);
	}
}