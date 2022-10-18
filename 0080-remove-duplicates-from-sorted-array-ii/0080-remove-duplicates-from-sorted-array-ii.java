class Solution {
	public int removeDuplicates(int[] nums) {
		int fp = 0;
		int sp = 0;

		int currDigit = nums[0];
		int count = 0;
		
		while (sp < nums.length) {
			if (nums[sp] == currDigit)
				count ++;

			else {
				nums[fp] = currDigit;
                nums[fp + (count > 1 ? 1 : 0)] = currDigit;
				fp += Math.min(count, 2);
				currDigit = nums[sp];
                count = 1;
			}

			sp ++;
		}
        
        nums[fp] = currDigit;
        nums[fp + (count > 1 ? 1 : 0)] = currDigit;
        fp += Math.min(count, 2);
        
		return fp;
	}

}