class Solution {
	public List<List<String>> groupAnagrams(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		
        for (int i = 0; i < strings.length; i++) {
			String string = strings[i];
			String sorted = sortedString(string);
			if (!map.containsKey(sorted))
				map.put(sorted, new ArrayList<>());
            map.get(sorted).add(string);
		}

		return new ArrayList<>(map.values());
	}

	private String sortedString(String string) {
        int[] hash = new int[26];
        for (int i = 0; i < string.length(); i ++)
            hash[string.charAt(i) - 'a'] += 1;
        
		return Arrays.toString(hash);
	}
}