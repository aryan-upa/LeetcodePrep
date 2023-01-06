class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // using counting sort.
        int n = costs.length;
        int count = 0;
        
        int m = costs[0];
        for (int cost : costs)
            m = m > cost ? m : cost;
        
        int[] costFreq = new int[m + 1];
        for (int cost : costs)
            costFreq [cost] ++;
        
        for (int cost = 1; cost <= m; cost ++) {
            if (costFreq[cost] == 0)
                continue;

            if (coins < cost) break;
            
            int toBuy = Math.min (costFreq[cost], coins / cost);
            coins -= cost * toBuy;
            count += toBuy;
        }
        
        return count;
    }
}