class Solution {
	public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
		String[] Combinations = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		List<String> res = new ArrayList<>();
		printPermutations(Combinations, digits, 0, "", res);

		return res;
	}

	public void printPermutations(String[] combinations, String digits, int charInd, String generatedString, List<String> res) {
		if (generatedString.length() == digits.length()) {
			res.add(generatedString);
			return;
		}

		int ind = Integer.parseInt("" + digits.charAt(charInd));
		for (char c : combinations[ind].toCharArray())
			printPermutations(combinations, digits, charInd + 1, generatedString + c, res);
	}
    
}