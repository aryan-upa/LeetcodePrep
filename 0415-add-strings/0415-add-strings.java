class Solution {
	public String addStrings(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();

		if (len1 == 0 || len2 == 0)
			return len1 > 0 ? num1 : num2;

		num1 = reverse(num1);
		num2 = reverse(num2);

		StringBuilder res = new StringBuilder();

		int i = 0, j = 0, sum = 0, carry = 0;
		while (i < len1 || j < len2) {
			sum = 0;

			if (i < len1) sum = num1.charAt(i) - '0';
			if (j < len2) sum += num2.charAt(j) - '0';
			sum += carry;

			res.append(sum % 10);
			carry = sum / 10;

			i ++;
			j ++;
		}

        if (carry != 0)
            res.append(carry);
        
		return res.reverse().toString();
	}

	public static String reverse(String inp) {
		StringBuilder sb = new StringBuilder(inp);
		sb.reverse();
		return sb.toString();
	}

}