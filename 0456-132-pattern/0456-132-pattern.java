class Solution {
    public boolean find132pattern(int[] nums) {
		int[] min = new int[nums.length];
		int minVal = nums[0];

		min[0] = nums[0];
		for (int i = 1; i < nums.length; i ++)
			min[i] = Math.min(min[i - 1], nums[i]);

		Stack<Integer> stack = new Stack<>();

		for (int i = nums.length - 1; i >= 0 ; i --) {
			int ith = min[i];

            while (!stack.isEmpty() && ith >= nums[stack.peek()])
				stack.pop();

			if (!stack.isEmpty() && nums[i] > nums[stack.peek()])
				return true;

			stack.push(i);
		}

		return false;
	}
}