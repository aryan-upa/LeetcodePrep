class Solution {
	public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        if (digits[len - 1] != 9) {
            digits[len - 1] ++;
            return digits;            
        }
        
        int pos = len - 1;
        
        while (pos >= 0 && digits[pos] == 9)
            digits[pos --] = 0;
        
        if (pos == -1) {
            int[] temp = new int[len + 1];
            temp[0] = 1;
            return temp;
        }
        
        digits[pos] ++;
        return digits;
        
	}
}