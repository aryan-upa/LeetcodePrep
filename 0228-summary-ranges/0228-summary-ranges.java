class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0)
            return res;
        
        if (nums.length == 1) {
            res.add("" + nums[0]);
            return res;
        }
                
        int s = 0; // start marker
        int c = 0; // current element marker
        int e = 1; // end marker
        
        while (e < nums.length) {
            if (nums[e] != nums[c] + 1) {
                String range = "" + nums[s];
                if (s != c)
                    range += "->" + nums[c];
                res.add(range);
                s = c + 1;
            }
            e += 1;
            c += 1;
        }
        
        String range = "" + nums[s];
        if (s != c)
            range += "->" + nums[c];
        
        res.add(range);
            
        return res;
    }
}