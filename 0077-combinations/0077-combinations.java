class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> output = new ArrayList<>();
		combineCombination(n, k, 0, 0, new ArrayList<>(), output);
		return output;
	}

	public void combineCombination(int n, int k, int added, int last, ArrayList<Integer> res, List<List<Integer>> output) {
		if (k == added) {
			output.add(List.copyOf(res));
			return;
		}

		for (int i = last + 1; i <= n; i ++) {
			res.add(i);
			combineCombination(n, k, added + 1, i, res, output);
			res.remove(added);
		}
	}

}