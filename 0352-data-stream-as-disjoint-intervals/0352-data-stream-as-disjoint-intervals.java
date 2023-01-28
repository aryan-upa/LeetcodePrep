class SummaryRanges {

	ArrayList<int[]> list;
	int[][] summary;
	boolean[] nums;

	public SummaryRanges() {
		list = new ArrayList<>();
		nums = new boolean[10001];
		summary = new int[0][2];
	}

	public void addNum(int value) {
		nums[value] = true;

		ArrayList<int[]> nList = new ArrayList<>();
		int[] range = newRange(value);

		for (int[] n : list) {
			if (n[1] < range[0] || n[0] > range[1])
				nList.add(n);
		}

		nList.add(range);
		list = nList;
	}

	private int[] newRange(int val) {
		int l = val;
		int r = val;

		while (l >= 0 && nums[l]) l --;
		while (r < nums.length && nums[r]) r ++;

		return new int[]{l+1, r-1};
	}

	public int[][] getIntervals() {
		if (list.size() == 0)
			return null;

		summary = new int[list.size()][2];
		int i = 0;

		for (int[] sum : list)
			summary[i++] = sum;

		if (summary.length > 1)
			Arrays.sort(summary, Comparator.comparingInt(s -> s[0]));

		return summary;
	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */