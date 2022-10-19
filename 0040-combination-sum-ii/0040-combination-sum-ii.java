class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> output = new ArrayList<>();
		combinationSumHelper(candidates, target, 0, new ArrayList<>(), 0, output);
		return output;
	}

	public void combinationSumHelper(int[] candidates, int target, int k, ArrayList<Integer> res, int added, List<List<Integer>> output) {
		if (target < 0)
			return;

		if (target == 0) {
			output.add(List.copyOf(res));
			return;
		}

		for (int i = k; i < candidates.length; i ++) {
            if (candidates[i] > target) return;
			if (i!= k && candidates[i] == candidates[i-1])
				continue;

			res.add(candidates[i]);
			combinationSumHelper(candidates, target - candidates[i], i + 1, res, added+1, output);
			res.remove(added);
		}
	}

    
}