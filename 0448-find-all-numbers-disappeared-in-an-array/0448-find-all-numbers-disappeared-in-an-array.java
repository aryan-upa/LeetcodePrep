class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // trying the n* log(n) approach
        
        Arrays.sort(nums); // not a good approach to modify the input data.
        int seek = 1;
        ArrayList<Integer> res = new ArrayList<>();

        int maxVal = 0;
        for (int i = 0; i < nums.length; i ++)
            maxVal = maxVal > nums[i] ? maxVal : nums[i];
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= seek) {
                seek += nums[i] == seek ? 1 : 0;
                continue;
            }
            while (seek < nums[i])
                res.add(seek++);
            seek ++;
        }
        
        if (maxVal == nums.length)
            return res;
        
        while (maxVal < nums.length) res.add(++maxVal);
        
        return res;
    }
}