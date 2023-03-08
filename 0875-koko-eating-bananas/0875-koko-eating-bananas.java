class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long min = 1;
        long max = Integer.MIN_VALUE;
        
        for (int i : piles)
            max = i > max ? i : max;
        
        while (min < max) {
            long md = (max + min) / 2;
            
            if (isPossible(piles, md, h)) {
                max = md;
            } else {
                min = md + 1;
            }
        }
        
        return (int) max;
    }
    
    public boolean isPossible(int[] piles, long k, int h) {
        int hourCount = 0;

        for (int pile : piles) {
            hourCount += pile / k;
            hourCount += pile % k == 0 ? 0 : 1;
        }
        
        return hourCount <= h;
    }
}