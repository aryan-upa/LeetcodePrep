class Solution {
	public String addBinary(String a, String b) {
		String shorter = a.length() <= b.length() ? a : b;
		String longer = a.length() > b.length() ? a : b;

		int shortLen = shorter.length(), longerLen = longer.length();
		a = new StringBuilder(String.valueOf("0".repeat(longerLen - shortLen).toCharArray()) + shorter).reverse().toString();
		b = new StringBuilder(longer).reverse().toString();

		int pos = 0, len = a.length(), carry = 0;
		StringBuilder res = new StringBuilder();

		int sum;
		while (pos < len) {
			sum = 0;
			if (a.charAt(pos) == '1')
				sum += 1;

			if (b.charAt(pos) == '1')
				sum += 1;

			if (carry == 1)
				sum += 1;

			res.append(sum%2);
			carry = sum/2;

			pos ++;
		}

		if (carry != 0) res.append(1);

		return res.reverse().toString();
	}

}