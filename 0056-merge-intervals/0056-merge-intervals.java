class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			// comparator function to compare two ranges.
			return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
		});

		ArrayList<int[]> list = new ArrayList<>();
		int min = intervals[0][0];
		int max = intervals[0][1];

		int[] interval;
		for (int i = 0; i < intervals.length; i ++) {
			interval = intervals[i];
			if (interval[0] <= max)
				max = Math.max(interval[1], max);

			else {
				list.add(new int[]{min, max});
				min = interval[0];
				max = interval[1];
			}
		}

		list.add(new int[]{min, max});
		int[][] res = new int[list.size()][2];

		for (int i = 0; i < list.size(); i ++)
			res[i] = list.get(i);

		return res;
	}
}

/* test-cases :
	[[1,3],[2,6],[8,10],[15,18]]
	[[1,4],[4,5]]
	[[1,2]]
	[[1,1],[2,2],[1,2]]
	[[1,1],[1,1]]
	[[1,1],[2,3],[1,2]]
	[[1,1],[2,2]]
	[[1,4],[2,3]]
*/