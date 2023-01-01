class Solution {
	public boolean wordPattern(String pattern, String s) {
		String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
		HashMap<String, Character> map = new HashMap<>();

		int i = 0;
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			if (!map.containsKey(word)) {
				if (map.containsValue(pattern.charAt(i)))
					return false;
				map.put(word, pattern.charAt(i));
			}
			sb.append(map.get(word));
			i++;
		}

		return sb.toString().equals(pattern);
	}
}