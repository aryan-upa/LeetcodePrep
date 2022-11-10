class Solution {
	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();

		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i ++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				stack.pop();
			} else
				stack.push(s.charAt(i));
		}

		char[] res = new char[stack.size()];
		for (int i = res.length - 1; i >= 0; i --)
			res[i] = stack.pop();

		return new String(res);
	}

}