class Solution {
	public int[] singleNumber(int[] nums) {
		int xor = 0; // using the property of XOR.
		for (int i : nums)
			xor ^= i;

		// this xor contains both the values.
		int separator = xor & ~(xor - 1); // this is to find the number which separates the nums array.

		int a = 0;
		for (int i : nums)
			if ((separator & i) != 0)
				a ^= i;
		
		return new int[]{a, xor^a};
	}
}