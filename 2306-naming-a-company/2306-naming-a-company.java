class Solution {
    public long distinctNames(String[] ideas) {
		HashMap<Character, HashSet<String>> map = new HashMap<>();
		for (int i = 0; i < 26; i ++)
			map.put((char) ('a' + i), new HashSet<>());

		for (String s : ideas)
			map.get(s.charAt(0)).add(s.substring(1));

		long count = 0;
		for (int i = 0; i < 25; i ++) {
			for (int j = i + 1; j < 26; j ++) {
				char fst = (char) ('a' + i);
				char sec = (char) ('a' + j);

				if (map.get(fst).size() == 0 || map.get(sec).size() == 0)
					continue;

				int c1 = map.get(fst).size();
				int c2 = map.get(sec).size();

				int similarCount = 0;
				for (String s : map.get(fst))
					if (map.get(sec).contains(s))
						similarCount ++;

				count += (long) (c1 - similarCount) * (c2 - similarCount) * 2;
			}
		}

		return count;
	}
}