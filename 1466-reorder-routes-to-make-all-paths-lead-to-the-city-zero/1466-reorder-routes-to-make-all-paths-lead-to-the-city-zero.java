class Solution {
	public int minReorder(int n, int[][] connections) {
		Map<Integer, Map<Integer, Boolean>> map = new HashMap<>();

		for (int i = 0; i < n; i ++)
			map.put(i, new HashMap<>());

		for (int[] edge : connections) {
			map.get(edge[0]).put(edge[1], true);
			map.get(edge[1]).put(edge[0], false);
		}

		return travelEdges (0, map, new HashSet<>());
	}

	private int travelEdges (
			int idx,
			Map<Integer, Map<Integer, Boolean>> map,
			Set<Integer> visited) {
		int count = 0;
		
		if (visited.contains(idx))
			return 0;
		
		visited.add(idx);
		for (int nbh : map.get(idx).keySet()) {
            if (visited.contains(nbh))
                continue;

            count += travelEdges(nbh, map, visited);
			count += map.get(idx).get(nbh) ? 1 : 0;
		}
		
		return count;
	}
}