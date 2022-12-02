class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int[] cpy = arr;
        Arrays.sort(cpy);
        
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 1; i < cpy.length; i ++)
            minAbsDiff = Math.min(minAbsDiff, Math.abs(cpy[i] - cpy[i-1]));
        
        // System.out.println(minAbsDiff);
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < cpy.length - 1; i ++) {
            List<Integer> pair = new ArrayList<>();
            int pos = i + 1;
            pair.add(cpy[i]);
            while (pos < cpy.length) {
                int diff = Math.abs(cpy[pos] - cpy[i]);
                if (diff == minAbsDiff) {
                    pair.add(cpy[pos]);
                    res.add(pair);
                    break;
                }
                else if (diff > minAbsDiff)
                    break;
                pos ++;
            }
        }
        
        return res;
    }
}