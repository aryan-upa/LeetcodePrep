class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < n; i ++)
            graph.put(i, new ArrayList<>()); // these array list contains the direct subordinates of employee i.
        
        for (int i = 0; i < manager.length; i ++) {
            int managedBy = manager[i];
            if (managedBy == -1) continue;
            graph.get(managedBy).add(i);
        }
        
        return dfs (headID, graph, informTime);
    }
    
    public int dfs (int bossID, Map<Integer, List<Integer>> graph, int[] informTime) {
        int timeCount = informTime[bossID];        
        int maxChildCount = 0;

        for (int subord : graph.get(bossID))
            maxChildCount = Math.max(maxChildCount, dfs (subord, graph, informTime));
        
        return timeCount + maxChildCount;
    }
}