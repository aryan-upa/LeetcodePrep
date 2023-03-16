class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        
        Arrays.sort(nums);
        int len = nums.length;
        
        for(int i = 0; i < len - 2; i ++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int left = i + 1;
                int right = len - 1;
                
                int sum = 0 - nums[i];

                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);

                        while(left < right && nums[left] == nums[left+1])
                            left++;

                        while(left < right && nums[right] == nums[right-1])
                            right--;

                        left++;
                        right--;
                    }

                    else if(nums[left] + nums[right] < sum)
                        left++;

                    else
                        right--;
                }
            }
        }

        return res; 
    }
}