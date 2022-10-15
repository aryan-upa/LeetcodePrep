class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> output = new ArrayList<>();
		combinationSumHelper(candidates, target, new ArrayList<>(), 0, output);
		return output;
	}

	public void combinationSumHelper(int[] candidates, int target, ArrayList<Integer> res, int currIdx, List<List<Integer>> output) {
		if (target < 0)
			return;

		if (target == 0) {
			output.add(List.copyOf(res));
			return;
		}

		for (int i = currIdx; i < candidates.length; i ++) {
			int candidate = candidates[i];
			res.add(candidate);
			combinationSumHelper(candidates, target - candidate, res, i, output);
			res.remove(res.size() - 1);
		}
	}
}