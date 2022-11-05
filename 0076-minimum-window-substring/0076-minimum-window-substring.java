class Solution {
	public String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < t.length(); i ++)
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

		int l, h, count;
		l = h = 0;
		boolean hasCountBeenZero = false;
		String res = s;
		count = map.size();

		while (h < s.length()) {
			char c = s.charAt(h);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				count = count - (map.get(c) == 0 ? 1 : 0);
			}

			while (l < s.length() && (count == 0 || !map.containsKey(s.charAt(l)))) {

				if (count == 0) {
					hasCountBeenZero = true;
					res = s.substring(l, h+1).length() < res.length() ? s.substring(l, h+1) : res;
				}

				char c1 = s.charAt(l);
				if (map.containsKey(s.charAt(l))) {
					map.put(c1, map.get(c1) + 1);
					if (map.get(c1) > 0)
						count ++;
				}

				l ++;
			}

			h ++;
		}

		return hasCountBeenZero ? res : "";
	}
}