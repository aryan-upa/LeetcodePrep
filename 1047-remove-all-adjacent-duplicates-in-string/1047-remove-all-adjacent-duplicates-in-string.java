class Solution {
	public String removeDuplicates(String s) {
        char[] stack = new char[s.length()];
        int pos = -1;

		stack[++pos] = s.charAt(0);
		for (int i = 1; i < s.length(); i ++) {
			if (!(pos == -1) && stack[pos] == s.charAt(i)) {
				pos --;
			} else
                stack[++pos] = s.charAt(i);
		}

		return new String(Arrays.copyOf(stack, pos+1));
	}

}