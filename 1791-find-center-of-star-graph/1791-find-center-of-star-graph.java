import java.util.Set;
import java.util.HashSet;

class Solution {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
        
//         int a = edges[0][0];
//         int b = edges[0][1];
//         int c = edges[1][0];
//         int d = edges[1][1];
        
//         return a == c || a == d ? a : b;
        
//         Set<Integer> nodeSet = new HashSet<>();

//         for (int[] edge : edges) {
//             if (nodeSet.contains(edge[0])) return edge[0];
//             if (nodeSet.contains(edge[1])) return edge[1];
            
//             nodeSet.add(edge[0]);
//             nodeSet.add(edge[1]);
//         }
        
//         return -1;
        
//         int edgeCount = edges.length;
//         int[] nodeEdgeCount = new int[edgeCount + 2];
        
//         for (int[] edge : edges) {
//             int x = edge[0];
//             int y = edge[1];
            
//             nodeEdgeCount[x] += 1;
//             nodeEdgeCount[y] += 1;
            
//             if (nodeEdgeCount[x] > 1) return x;
//             if (nodeEdgeCount[y] > 1) return y;
//         }
        
//         return -1;
    }
}