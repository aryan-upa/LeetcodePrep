class Solution {
	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		int sum, carry = 0;
		int l1 = a.length() - 1, l2 = b.length() - 1;

		while (l1 >= 0 || l2 >= 0) {
			sum = 0;

			sum += l1 >= 0 ? a.charAt(l1--) - '0' : 0;
			sum += l2 >= 0 ? b.charAt(l2--) - '0' : 0;
			sum += carry;

			res.append(sum % 2);
			carry = sum/2;
		}

		if (carry != 0)
			res.append(1);

		return res.reverse().toString();
	}
}