class Solution {
    public boolean isValid(int[] weights, int maxLoad, int maxDays) {
        int daysCount = 1;
        int wt = 0;
        
        for (int weight : weights) {
            wt += weight;

            if (wt > maxLoad) {
                daysCount += 1;
                wt = weight;
            }
        }

        return daysCount <= maxDays;
    }

    public int shipWithinDays (int[] weights, int days) {
        int sumLoad = 0;
        int maxW = 0;
        
        for (int weight : weights) {
            sumLoad += weight;
            maxW = Math.max(maxW, weight);
        }

        int h = sumLoad;
        int l = maxW;

        while (l < h) {
            int mid = (l + h) / 2;
            
            if (isValid(weights, mid, days)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}