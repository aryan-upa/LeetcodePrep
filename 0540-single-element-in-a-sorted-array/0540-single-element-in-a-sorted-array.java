class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
                
        int s = 0;
        int e = nums.length - 1;
        
        while (s < e) {
            int mid = s + (e - s) / 2;
            int mVal = nums[mid];
            
            if (mid != 0 && mVal == nums[mid - 1]) {
                int elementCount = mid - s + 1;
                if (elementCount % 2 == 0)
                    s = mid + 1;
                else
                    e = mid;
            } 
            else if (mid != nums.length - 1 && mVal == nums[mid + 1]) {
                int elementCount = e - mid + 1;
                if (elementCount % 2 == 0)
                    e = mid - 1;
                else
                    s = mid;                
            }
            else
                return nums[mid];
            
        }
        
        return nums[e];
    }
}