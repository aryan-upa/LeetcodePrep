class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            sum[i+1] = sum[i] + nums[i];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i ++)
            ans[i] = res(queries[i], sum);
        
        return ans;
    }

    public int res(int top,int[] sum) {
        int low = 0;
        int high = sum.length - 1;

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sum[mid] <= top) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        } 

        return ans;
    } 
}