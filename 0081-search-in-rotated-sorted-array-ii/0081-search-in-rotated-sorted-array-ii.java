class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return true;

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }

            boolean pivotArray = existsInFirst(nums, start, nums[mid]);

            boolean targetArray = existsInFirst(nums, start, target);
            if (pivotArray ^ targetArray) {
                if (pivotArray)
                    start = mid + 1;
                else
                    end = mid - 1; 
            } else { 
                if (nums[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        
        return false;
    }

    // returns true if we can reduce the search space in current binary search space
    private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    // returns true if element exists in first array, false if it exists in second
    private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }
}