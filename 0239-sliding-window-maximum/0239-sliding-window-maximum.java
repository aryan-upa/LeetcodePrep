class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
		Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[arr.length - k + 1];
		
        for (int i = 0; i < k; i ++) {
			while (!deque.isEmpty() && arr[i] > arr[deque.getLast()])
				deque.removeLast(); // just remove is removeFirst.
			deque.add(i);
		}
		
        ans[0] = arr[deque.getFirst()];
		int count = 0;
	
        for (int i = k; i < arr.length; i ++) {
			while (!deque.isEmpty() && arr[i] > arr[deque.getLast()])
				deque.removeLast();
		
            deque.add(i);
			
            if (deque.getFirst() == i - k)
				deque.removeFirst();
			ans[++count] = arr[deque.getFirst()];
		}
		
        return ans;
	}
}
