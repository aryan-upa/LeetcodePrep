class Solution {
	public List<List<String>> groupAnagrams(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		
        for (int i = 0; i < strings.length; i++) {
			String string = strings[i];
			String sorted = sortedString(string);
			if (map.containsKey(sorted))
				map.get(sorted).add(string);
			else {
				map.put(sorted, new ArrayList<>());
				map.get(sorted).add(string);
			}
		}

		return new ArrayList<>(map.values());
	}

	private String sortedString(String string) {
		char[] arr = string.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}