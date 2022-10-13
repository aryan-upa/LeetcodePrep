class Solution {
	public int lengthOfLongestSubstring(String s) {
		int l = 0;
		int h = 0;

		int[] freq = new int[256];
		int maxLen = 0;
		boolean repeated = false;

		while (h < s.length()) {
			int idx = s.charAt(h);
			if (freq[idx] > 0)
				repeated = true;
			freq[idx] ++;

			while (repeated) {
				int localIdx = s.charAt(l);
				freq[localIdx]--;
				if (freq[localIdx] == 1)
					repeated = false;
				l++;
			}

			maxLen = Math.max(maxLen, (h - l + 1));
			h ++;
		}

		return maxLen;
	}
}