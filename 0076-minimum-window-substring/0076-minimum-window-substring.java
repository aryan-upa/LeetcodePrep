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
        int resLen = s.length();
		count = map.size();

		while (h < s.length()) {
			char c = s.charAt(h);
			if (map.containsKey(c)) {
                int mapGet = map.get(c);
				map.put(c, mapGet - 1);
				count = count - ((mapGet - 1) == 0 ? 1 : 0);
			}

			while (l < s.length() && (count == 0 || !map.containsKey(s.charAt(l)))) {

				if (count == 0) {
					hasCountBeenZero = true;
					res = (h - l + 1) < resLen ? s.substring(l, h+1) : res;
                    resLen = res.length();
				}

				char c1 = s.charAt(l);
				if (map.containsKey(s.charAt(l))) {
                    int mapGet = map.get(c1);
					map.put(c1, mapGet + 1);
					if ((mapGet+1) > 0)
						count ++;
				}

				l ++;
			}

			h ++;
		}

		return hasCountBeenZero ? res : "";
	}
}