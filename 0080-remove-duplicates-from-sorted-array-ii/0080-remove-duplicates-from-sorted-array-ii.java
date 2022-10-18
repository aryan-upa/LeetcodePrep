class Solution {
	public int removeDuplicates(int[] nums) {
		int fp = 0;
		int sp = 0;

		int currDigit = nums[0];
		int count = 0;
		
		while (sp < nums.length) {
			if (nums[sp] == currDigit)
				count ++;

			else if (nums[sp] != currDigit) {
				nums[fp] = currDigit;
                if (count > 1)
                    nums[fp + 1] = currDigit;
				fp += Math.min(count, 2);
				currDigit = nums[sp];
                count = 1;
			}

			sp ++;
		}
        
        nums[fp] = currDigit;
        if (count > 1)
            nums[fp + 1] = currDigit;
        fp += Math.min(count, 2);
        
		return fp;
	}

}