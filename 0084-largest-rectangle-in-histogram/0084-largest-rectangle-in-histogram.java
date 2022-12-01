class Solution {
    public int largestRectangleArea(int[] heights) {
        return area(heights);
     }
    
    public static int area(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i ++) {
			while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
				int h = arr[stack.pop()];
				int r = i;

				if (stack.isEmpty())
					maxArea = Math.max(maxArea, h*r);
				else {
					int l = stack.peek();
					maxArea = Math.max(maxArea, h * (r - l -1));
				}
			}
			stack.push(i);
		}

		/*
			Now for the remaining element in the array...
			These elements are those which do not have the right minimum.
			If the array is sorted in increasing manner, then all the elements will be remaining after the first 
				iteration.
		*/

		int r = arr.length;
		while (!stack.isEmpty()) {
			int h = arr[stack.pop()];

			if (stack.isEmpty())
				maxArea = Math.max(maxArea, h*r);
			else {
				int l = stack.peek();
				maxArea = Math.max(maxArea, h*(r-l-1));
			}
		}

		return maxArea;
	}

}