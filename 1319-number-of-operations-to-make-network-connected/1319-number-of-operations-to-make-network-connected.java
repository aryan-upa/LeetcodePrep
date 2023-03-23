class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for (int i = 0; i < n; i ++)
            adjacency.put(i, new ArrayList<>());
        
        for (int[] conn : connections) {
            adjacency.get(conn[0]).add(conn[1]);
            adjacency.get(conn[1]).add(conn[0]);
        }
        
        int disconnectedComponents = 0;
        boolean[] isVisited = new boolean[n];
        
        for (int i = 0; i < n; i ++) {
            if (!isVisited[i]) {
                disconnectedComponents += 1;
                dfs (adjacency, isVisited, i);
            }
        }
        
        return disconnectedComponents - 1;
    }
    
    public void dfs (
        Map<Integer, List<Integer>> adjacency,
        boolean[] isVisited,
        int idx ) {
        isVisited [idx] = true;
        
        for (int nbh : adjacency.get(idx)) {
            if (isVisited[nbh])
                continue;
            
            isVisited[nbh] = true;
            dfs (adjacency, isVisited, nbh);
        }
    }
}