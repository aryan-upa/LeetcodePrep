class Solution {
	public boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length())
			return false;

		int[] occ = new int[26];
		HashSet<Character> setOfs1Chars = new HashSet<>();

		for (char c : s1.toCharArray()) {
			occ[c - 'a'] += 1;
			setOfs1Chars.add(c);
		}

		int count = s1.length();
		int s = 0;
		int e = 0;

		int[] temp = Arrays.copyOf(occ, occ.length);
		int present = 0;

		while (e < s2.length()) {
			char c = s2.charAt(e);
			if (!setOfs1Chars.contains(c)) {
				e += 1;
				s = e;
				temp = Arrays.copyOf(occ, occ.length);
				present = 0;
				continue;
			}

			while (temp[c - 'a'] == 0 && present > 0) {
				temp[s2.charAt(s) - 'a'] += 1;
				s += 1;
				present -= 1;
			}

			temp [c - 'a'] -= 1;
			present += 1;

			if (present == count)
				return true;

			e += 1;
		}

		return false;
	}
}