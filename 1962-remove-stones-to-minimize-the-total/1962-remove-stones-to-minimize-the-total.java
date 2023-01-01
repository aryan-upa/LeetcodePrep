class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heamp = new PriorityQueue<>((a, b) -> b - a);

        for (int stones: piles)
            heamp.add(stones);
        
        for (int i = 0; i < k; i++) {
            int c = heamp.remove();
            int r = c / 2;
            heamp.add(c - r);
        }
        
        int ans = 0;
        for (int stones: heamp)
            ans += stones;
        
        return ans;
    }
}