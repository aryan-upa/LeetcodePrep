class Solution {
	public boolean isNumber(String s) {
        s = s.toLowerCase();
        
		if (s.indexOf('e') < 0)
			return isValidDecimal(s);
		else {
            int eCount = 0;
			for (int i = 0; i < s.length(); i ++)
                if (s.charAt(i) == 'e')
                    eCount ++;
            
            if (eCount > 1)
                return false;
            
            String[] nums = s.split("e");
			if (nums.length != 2)
				return false;
			if (nums[0].length() == 0 || nums[1].length() == 0)
				return false;
			return isValidDecimal(nums[0]) && isValidInteger(nums[1]);
		}
	}

	public static boolean isValidDecimal(String str) {
		boolean hasSign = false, hasDot = false, hasNum = false;
		int pos = 0;

		if (str.charAt(pos) == '+' || str.charAt(pos) == '-') {
			hasSign = true;
			pos ++;
		}

		if (hasSign && pos == str.length())
			return false;

		while (pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
			pos++;
			hasNum = true;
		}

		if (pos == str.length())
			return true;

		if (str.charAt(pos) == '.') {
			hasDot = true;
			pos ++;
		}

		if (hasDot)
			while (pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
				pos++;
				hasNum = true;
			}

		if (hasDot && !hasNum)
			return false;

		return pos == str.length();
	}

	public static boolean isValidInteger(String str) {
		boolean hasSign = false;

		int pos = 0;

		if (str.charAt(pos) == '+' || str.charAt(pos) == '-') {
			hasSign = true;
			pos ++;
		}

		if (hasSign && pos == str.length())
			return false;

		while (pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9')
			pos ++;

		return pos == str.length();
	}
}