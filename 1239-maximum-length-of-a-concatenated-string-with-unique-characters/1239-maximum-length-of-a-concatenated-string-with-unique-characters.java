class Solution {
    
    static String result;
    
    public int maxLength(List<String> arr) {
        result = "";

        for (int i = 0; i < arr.size(); i ++)
			getSubsequences(arr, i, arr.get(i));

        return result.length();
    }
    
    public static void getSubsequences(List<String> arr, int index, String res) {
		if (!isValid(res))
			return;

		if (res.length() > result.length())
			result = res;

		for (int i = index + 1; i < arr.size(); i ++)
			getSubsequences(arr, i, res + arr.get(i));
	}

	public static boolean isValid(String res) {
		int[] ch = new int[26];

		for (int i = 0; i < res.length(); i ++) {
			if (ch[res.charAt(i) - 'a'] == 1)
				return false;
			else
				ch[res.charAt(i) - 'a'] = 1;
		}

		return true;
	}
}