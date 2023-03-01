class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length != 1)
            nums = mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public int[] mergeSort(int[] nums, int s, int e) {
        if (s < e) {
            int mid = s + (e - s)/2;
            int[] left = mergeSort(nums, s, mid);
            int[] right = mergeSort(nums, mid + 1, e);
            return merge(left, right);
        }
        
        return new int[]{nums[s]};
    }
    
    public int[] merge(int[] left, int[] right) {
        int [] res = new int[left.length + right.length];
        int lI = 0;
        int rI = 0;
        int resI = 0;
        
        while (lI < left.length && rI < right.length) {
            if (left[lI] <= right[rI])
                res[resI ++] = left[lI ++]; 
            else
                res[resI ++] = right[rI ++];
        }
        
        while (rI < right.length)
            res[resI ++] = right[rI ++];
        
        while (lI < left.length)
            res[resI ++] = left[lI ++];
        
        return res;
    }
}