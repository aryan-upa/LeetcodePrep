class Solution {
	public String countAndSay(int n) {
		String base = "1";

		for (int i = 1; i < n; i ++)
			base = countAndSayHelper(base);

		return base;
	}

	public String countAndSayHelper(String base) {
		StringBuilder res = new StringBuilder();

		int count = 0;
		char dig = base.charAt(0);
		int len = base.length();

		for (int i = 0; i < len; i ++) {
			if (dig == base.charAt(i))
				count ++;
			else {
				res.append(count);
				res.append(dig);
				dig = base.charAt(i);
				count = 1;
			}
		}

		res.append(count);
		res.append(dig);

		return res.toString();
	}
}