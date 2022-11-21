class Solution {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9'))
				sb.append(c);
		}

		return isPalindromeHelper(sb.toString());
	}
	
	public boolean isPalindromeHelper(String s) {
		int l = 0;
		int h = s.length() - 1;
		while (l < h) {
			if (s.charAt(l) != s.charAt(h))
				return false;
			l ++;
			h --;
		}
		return true;
	}
}