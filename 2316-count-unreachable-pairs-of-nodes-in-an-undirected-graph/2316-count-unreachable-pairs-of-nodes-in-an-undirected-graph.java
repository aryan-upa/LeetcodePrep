class Solution {
	public long countPairs(int n, int[][] edges) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i ++)
			map.put(i, new ArrayList<>());

		for (int [] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		ArrayList<Integer> groups = new ArrayList<>();
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i ++) {
			if (!visited[i])
				groups.add(countNodes(i, map, visited));
		}

		long sum = 0;
		for (int v : groups)
			sum += ((long) v * (n-v));
		
		return sum / 2;
	}

	public int countNodes (int i, Map<Integer, List<Integer>> map, boolean[] visited) {
		if (visited[i])
			return 0;
		
		int count = 1;
        visited[i] = true;
		for (int nbh : map.get(i))
			if (!visited[nbh])
				count = count + countNodes(nbh, map, visited);
		
		return count;
	}
}