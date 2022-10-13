class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
		palindromePartitioningHelper(s,  new ArrayList<>(), output);
		return output;
    }
    
    public static void palindromePartitioningHelper(String ques, List<String> res, List<List<String>> output) {
		if (ques.equals("")) {
			output.add(List.copyOf(res));
			return;
		}

		for (int i = 1; i <= ques.length(); i ++) {
			String s1 = ques.substring(0, i);
			if (!isPalindrome(s1))
				continue;
			res.add(s1);
			palindromePartitioningHelper(ques.substring(i), res, output);
			res.remove(res.size() - 1);
		}
	}
    
    public static boolean isPalindrome(String str) {
		int l = 0;
		int h = str.length() - 1;

		while (l < h) {
			if (str.charAt(l) != str.charAt(h))
				return false;
			l ++;
			h --;
		}

		return true;
	}
}