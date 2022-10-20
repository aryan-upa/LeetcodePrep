class Solution {
	public String addStrings(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();

		if (len1 == 0 || len2 == 0)
			return len1 > 0 ? num1 : num2;

        StringBuilder res = new StringBuilder();

		int i = len1 - 1, j = len2 - 1, sum = 0, carry = 0;
		while (i >= 0 || j >= 0) {
			sum = 0;

			sum += i >= 0 ? num1.charAt(i) - '0' : 0;
			sum += j >= 0 ? num2.charAt(j) - '0' : 0;
			sum += carry;

			res.append(sum % 10);
			carry = sum / 10;

			i --;
			j --;
		}

        if (carry != 0)
            res.append(carry);
        
		return res.reverse().toString();
	}
}