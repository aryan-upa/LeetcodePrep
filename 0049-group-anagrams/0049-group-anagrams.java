class Solution {
	public List<List<String>> groupAnagrams(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();

		for (String s : strings) {
			String mapper = getStringMapper(s);
			List<String> ls = map.computeIfAbsent(mapper, m -> new ArrayList<>());
			ls.add(s);
		}

		return new ArrayList<>(map.values());
	}
	
	private String getStringMapper (String s) {
		int[] occ = new int[26];
		int len = s.length();
		
		for (int i = 0; i < len; i ++)
			occ[s.charAt(i) - 'a'] ++;
		
		return Arrays.toString(occ);
	}
}