class Solution {
	public static List<String> fizzBuzz(int n) {
		ArrayList<String> list = new ArrayList<>(n+1);
		list.add("");
		for(int i = 1; i <= n; i ++) {
			String val = "";
			if (i%3 == 0)
				val = "Fizz";
			if (i%5 == 0)
				val += "Buzz";
			if (val.equals(""))
				val = "" + i;
			list.add(val);
		}
		list.remove(0);
		return list;
	}
}