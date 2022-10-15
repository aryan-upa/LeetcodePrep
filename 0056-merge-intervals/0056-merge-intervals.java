class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			// comparator function to compare two ranges.
			return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
		});

		ArrayList<int[]> list = new ArrayList<>();
		int min = intervals[0][0];
		int max = intervals[0][1];

		for (int[] interval : intervals) {
			if (interval[0] == min) {
				max = Math.max(interval[1], max);
			}

			else if (interval[0] <= max) {
				max = Math.max(interval[1], max);
			}

			else {
				list.add(new int[]{min, max});
				min = interval[0];
				max = interval[1];
			}
		}

		list.add(new int[]{min, max});
		int[][] res = new int[list.size()][2];

		int i = 0;
		for (int[] interval : list)
			res[i++] = interval;

		return res;
	}
}