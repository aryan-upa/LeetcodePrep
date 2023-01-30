class Solution {
    public int findCenter(int[][] edges) {
        int edgeCount = edges.length;
        int[] nodeEdgeCount = new int[edgeCount + 2];
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            
            nodeEdgeCount[x] += 1;
            nodeEdgeCount[y] += 1;
            
            if (nodeEdgeCount[x] > 1) return x;
            if (nodeEdgeCount[y] > 1) return y;
        }
        
        return -1;
    }
}