class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		permuteHelper(nums, new ArrayList<>(), 0, output);
		return output;
	}

	public void permuteHelper(int[] nums, List<String> res, int cCount, List<List<Integer>> output) {
		if (cCount == nums.length) {
			ArrayList<Integer> temp = new ArrayList<>();

			for (String s : res)
				temp.add(Integer.parseInt(s));

			output.add(temp);
			return;
		}

		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] != Integer.MIN_VALUE) {
				int temp = nums[i];
				nums[i] = Integer.MIN_VALUE;

				res.add("" + temp);
				permuteHelper(nums, res, cCount + 1, output);
				res.remove("" + temp);

				nums[i] = temp;
			}
		}
	}
}