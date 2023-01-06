class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int i = 0;
        
        while (i < costs.length) {
            coins -= costs[i++];
            if (coins < 0)
                break;
            count ++;
        }
        
        return count;
    }
}