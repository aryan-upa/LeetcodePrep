class Solution {
    public List<Integer> findAnagrams(String fI, String ana) {
		ArrayList<Integer> res = new ArrayList<>();

		int[] occ = new int[26];
		HashSet<Character> set = new HashSet<>();

		for (char c : ana.toCharArray()) {
			occ[c - 'a'] += 1;
			set.add(c);
		}

		int count = ana.length();

		int s, e, present;
		s = e = present = 0;
		int[] temp = Arrays.copyOf(occ, occ.length);

		while (e < fI.length()) {
			char c = fI.charAt(e);
			if (!set.contains(c)) {
				e += 1;
				s = e;
				temp = Arrays.copyOf(occ, occ.length);
				present = 0;
				continue;
			}

			while (temp[c - 'a'] == 0 && s < fI.length()) {
				temp[fI.charAt(s) - 'a'] += 1;
				s += 1;
				present -= 1;
			}

			temp [c - 'a'] -= 1;
			present += 1;

			if (present == count) {
				res.add(s);
				temp[fI.charAt(s) - 'a'] += 1;
				s += 1;
				present -= 1;
			}

			e += 1;
		}

		return res;
    }
}