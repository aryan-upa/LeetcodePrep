class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        if (time.length == 1)
            return (long) time[0] * totalTrips;
        
        Arrays.sort(time);
        
        long minTime = 1;
        long maxTime = (long) time[0] * totalTrips;
        long res = maxTime;
        
        while (minTime < maxTime) {
            long mid = (maxTime + minTime) / 2;
            
            if (isPossible (time, mid, totalTrips)) {
                res = mid;
                maxTime = mid;
            } else 
                minTime = mid + 1;
        }
        
        return res;
    }
    
    public boolean isPossible (int[] times, long time, int tripCount) {
        long currentTripCount = 0;
        for (int interval : times) {
            long count = time / interval;
            if (count == 0) break;
            currentTripCount += count;
        }
        
        return currentTripCount >= tripCount;
    }
}