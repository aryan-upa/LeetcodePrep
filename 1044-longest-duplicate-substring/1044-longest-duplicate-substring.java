class Solution {
	public String longestDupSubstring(String s) {
		int low = 1, hi = s.length();
		String ans = "";

		while (low <= hi) {
			int mid = low + (hi - low) / 2;
			String possibleAns = solveQuestion(s, mid);
			if (possibleAns.length() > 0) {
				low = mid + 1;
				ans = possibleAns;
			} else {
				hi = mid - 1;
			}
		}

		return ans;
	}

	private static String solveQuestion (String s, int mid) {
		// we are using rabin karp algorithm, with reverse polynomial hashing.

		long mod = 1000_000_007;
		long pow = 1;
		long hashValue = 0;
		int prime = 31; // number more than 26, research shows that 31 is better than 29.
		for (int ei = mid - 1; ei >= 0; ei --) {
			hashValue = (hashValue + ((s.charAt(ei) - 'a' + 1) * pow) % mod) % mod; // adding value of character
			if (ei > 0)
				pow = (pow * prime) % mod;
		}

		HashMap <Long, List<Integer>> map = new HashMap<>();
		map.put(hashValue, new ArrayList<>());
		map.get(hashValue).add(0); // adding the starting index of the string which has the following hashValue.

		for (int ei = mid, si = 0; ei < s.length(); ei ++, si ++) {
			hashValue = (hashValue - ((s.charAt(si) - 'a' + 1) * pow) % mod) % mod;
			hashValue=(hashValue+mod)%mod;
			hashValue = (hashValue * prime) % mod;
			hashValue = (hashValue + s.charAt(ei) - 'a' + 1) % mod;
			if (map.containsKey(hashValue)) {
				String curr = s.substring(si + 1, ei + 1);
				for (int start : map.get(hashValue)) {
					if (curr.equals(s.substring(start, start + mid)))
						return curr;
				}
				map.get(hashValue).add(si + 1);
			}
            else {
                map.put(hashValue,new ArrayList<>());
                map.get(hashValue).add(si+1);
            }
		}

		return "";
	}
}