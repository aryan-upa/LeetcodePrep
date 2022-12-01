class Solution {
    public boolean find132pattern(int[] nums) {
		int[] min = new int[nums.length];
		int minVal = nums[0];

		min[0] = nums[0];
		for (int i = 1; i < nums.length; i ++)
			min[i] = Math.min(min[i - 1], nums[i]); // creating the left minimum array.

		Stack<Integer> stack = new Stack<>();

		for (int i = nums.length - 1; i >= 0 ; i --) {
			// nums[i] is current j.
			// for this j min[i] is i;
			// and we check k from the stack.

			int ith = min[i];
			while (!stack.isEmpty() && ith >= nums[stack.peek()]) // if ith > kth element, then pop the element in stack.
				stack.pop();

			if (!stack.isEmpty() && nums[i] > nums[stack.peek()]) // checking if jth element is greater than kth element which is at the top of stack.
				return true;

			stack.push(i);
		}

		return false;
	}
}