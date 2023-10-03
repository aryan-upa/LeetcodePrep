class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] occ = new int[101];
        
        for (int i : nums) 
            occ[i] += 1;
        
        int count = 0;
        for (int i : occ)
            count += i == 0 || i == 1 ? 0 : i * (i - 1) / 2;
        
        return count;
    }    
        
//     public int numIdenticalPairs(int[] nums) {
//         if (nums == null)
//             throw new NullPointerException("Array is Null!");
        
//         int[] occ = new int[101];
        
//         for (int i : nums)
//             occ[i] += 1;
        
//         int goodPairCount = 0;
//         for (int i = 0; i < occ.length; i ++) {
//             int occOfI = occ[i];
            
//             if (occOfI == 0 || occOfI == 1)
//                 continue;
            
//             int goodPairCountForI = occOfI * (occOfI - 1) / 2;
//             goodPairCount += goodPairCountForI;
//         }
        
//         return goodPairCount;
//     }
}