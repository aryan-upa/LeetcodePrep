class Solution {
    
    static private int[] primes;
    
    static {
        primes = new int[] {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101
        };
    }
    
	public List<List<String>> groupAnagrams(String[] strings) {
		Map<Long, List<String>> map = new HashMap<>();

		for (String s : strings) {
			Long mapper = getStringMapper(s);
			List<String> ls = map.computeIfAbsent(mapper, m -> new ArrayList<>());
			ls.add(s);
		}

		return new ArrayList<>(map.values());
	}
	
	private long getStringMapper (String s) {
        long prod = 1;
		int len = s.length();
		
		for (int i = 0; i < len; i ++) {
			prod *= primes[s.charAt(i) - 'a'];
            prod %= Long.MAX_VALUE;
        }
		
		return prod;
	}
}