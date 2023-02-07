class Solution {
    public int totalFruit(int[] fruits) {
		int start = 0;
		int end = 0;

		int[] fCount = new int[fruits.length];
		int types = 0;
		int maxLen = 0;
		while (end < fruits.length) {
			if (fCount[fruits[end]] == 0)
				types += 1;

			fCount[fruits[end]] += 1;

			while (types > 2 && start < fruits.length) {
				fCount[fruits[start]] -= 1;
				if (fCount[fruits[start]] == 0)
					types -= 1;
				start ++;
			}

			maxLen = Math.max(maxLen, end - start + 1);
			end ++;
		}

		return maxLen;
    }
}