class Solution {
	public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        // if the last digits is not 9, then there will never be an increment in array size.
        if (digits[len - 1] != 9) {
            digits[len - 1] ++;
            return digits;            
        }
        
        int pos = len - 1;
        
        while (pos >= 0 && digits[pos] == 9)
            digits[pos --] = 0; 
        /*
            Making element 0 because if at digits[pos] is 9, then (9 + 1) % 10 will be 0, that should be saved here. 
            Here, there's no carry being used out in front, but intrinsically it's pupose is being fulfilled.
        */
        
        if (pos == -1) {
            int[] temp = new int[len + 1];
            temp[0] = 1;
            // no need to copy the element of the previous array because the all will be zero anyways, line : 14
            return temp;
        }
        
        digits[pos] ++;
        return digits;        
	}
}