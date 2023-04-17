class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = Integer.MIN_VALUE;
        
        for (int i : candies)
            maxCandy = Math.max(i, maxCandy);
        
        List<Boolean> res = new ArrayList<>();
        for (int i : candies)
            res.add(i + extraCandies >= maxCandy);
        
        return res;
    }
}