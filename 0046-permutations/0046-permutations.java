class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		boolean[] isAdded = new boolean[nums.length];
		permuteHelper(nums, isAdded, new ArrayList<>(), 0, output);
		return output;
	}

	public void permuteHelper(int[] nums, boolean[] isAdded, List<String> res, int cCount, List<List<Integer>> output) {
		if (cCount == nums.length) {
			ArrayList<Integer> temp = new ArrayList<>();

			for (String s : res)
				temp.add(Integer.parseInt(s));

			output.add(temp);
			return;
		}

		for (int i = 0; i < nums.length; i ++) {
			if (!isAdded[i]) {
				isAdded[i] = true;

				res.add("" + nums[i]);
				permuteHelper(nums, isAdded, res, cCount + 1, output);
				res.remove("" + nums[i]);

				isAdded[i] = false;
			}
		}
	}
}