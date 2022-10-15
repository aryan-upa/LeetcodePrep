class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> output = new ArrayList<>();
		combinationSumHelper(candidates, target, new ArrayList<>(), 0, 0, output);
		return output;
	}

	public void combinationSumHelper(int[] candidates, int target, ArrayList<Integer> res, int currIdx, int tc, List<List<Integer>> output) {
		if (target < 0)
			return;

		if (target == 0) {
			output.add(List.copyOf(res));
			return;
		}

		for (int i = currIdx; i < candidates.length; i ++) {
			res.add(candidates[i]);
			combinationSumHelper(candidates, target - candidates[i], res, i, tc + 1, output);
			res.remove(tc);
		}
	}
}