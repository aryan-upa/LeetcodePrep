class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;
        
        for (int i = 0; i < n; i ++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue; // same bomb

                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];

                if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj))
                    graph.get(i).add(j);
            }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<>(), graph);
            answer = Math.max(answer, count);
        }

        return answer;
    }

    private int dfs(int cur, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        visited.add(cur);
        int count = 1;

        for (int nbh : graph.getOrDefault(cur, new ArrayList<>()))
            if (!visited.contains(nbh))
                count += dfs(nbh, visited, graph);
        
        return count;
    }
}