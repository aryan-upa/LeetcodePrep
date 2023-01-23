class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusties = new int[n];
        
        for (int[] trusts : trust)
            trusties[trusts[1] - 1] += 1;
        
        boolean isPossible = false;
        for (int val : trusties)
            if (val == n - 1) {
                isPossible = true;
                break;
            }
        
        if (!isPossible)
            return -1;
        
        boolean[] doesTrustSomeone = new boolean[n];
        for (int i = 0; i < trust.length; i ++)
            doesTrustSomeone[trust[i][0] - 1] = true;
        
        for (int i = 0; i < n; i ++) {
            if (trusties[i] == n - 1 && !doesTrustSomeone[i])
                return (i+1);
        }
        
        return -1;
    }
}