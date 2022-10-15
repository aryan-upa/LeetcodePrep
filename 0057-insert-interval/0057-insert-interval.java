class Solution {
	public int[][] insert(int[][] inters, int[] nI) {
        if (inters.length == 0)
            return new int[][]{nI};
        
		int insertionIndex = binarySearch(inters, nI);

		ArrayList<int[]> list = new ArrayList<>(Arrays.asList(inters));
		list.add(insertionIndex, nI);

		return merge(list, inters.length + 1);
	}

	public int[][] merge(ArrayList<int[]> intervals, int len) {
		intervals.sort((a, b) -> {
			// comparator function to compare two ranges.
			return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
		});

		ArrayList<int[]> list = new ArrayList<>();
		int min = intervals.get(0)[0];
		int max = intervals.get(0)[1];

		int[] interval;
		for (int i = 0; i < len; i ++) {
			interval = intervals.get(i);
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

	public int binarySearch(int[][] ints, int[] nI) {
		int lookFor = nI[0];
		int l = 0;
		int h = ints.length - 1;

		while (l < h) {
			int mid = (l + h) / 2;

			if (ints[mid][0] == lookFor)
				return mid + 1;

			if (ints[mid][0] < lookFor)
				l = mid + 1;

			else
				h = mid - 1;
		}

		if (lookFor > ints[ints.length - 1][0])
			return ints.length;
		else if (lookFor < ints[0][0])
			return 0;
		else
			return l + 1;
	}
}