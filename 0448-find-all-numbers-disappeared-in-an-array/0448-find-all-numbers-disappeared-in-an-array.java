class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // trying the n* log(n) approach
        
        Arrays.sort(nums); // not a good approach to modify the input data.
        int seek = 1;
        ArrayList<Integer> res = new ArrayList<>();

        int maxVal = nums[nums.length - 1];

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= seek) {
                seek += nums[i] == seek ? 1 : 0;
                continue;
            }
            while (seek < nums[i])
                res.add(seek++);
            seek ++;
        }

        while (maxVal < nums.length) res.add(++maxVal);
        return res;
    }
}