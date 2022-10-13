class Solution {
    public int numTilePossibilities(String str) {
		int[] freq = new int[26];
		for (char c : str.toCharArray())
			freq[c - 65] ++;
        return countPossibilities(freq, "");
	}

	private static int countPossibilities(int[] freq, String s) {
		int count = 0;
		for (int i = 0; i < freq.length; i ++) {
			if (freq[i] >= 1) {
				char ch = (char) (i + 'A');
				freq[i]--;
				count += countPossibilities(freq, s + ch) + 1;
				freq[i]++;
			}
		}
		return count;
	}
}