class Solution {
	public boolean canFinish (int courseCount, int[][] preReq) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < courseCount; i ++)
			map.put(i, new ArrayList<>());

		for (int[] edge : preReq)
			map.get(edge[1]).add(edge[0]);
		
		return topologicalSort(map);
	}

	public boolean topologicalSort (Map<Integer, List<Integer>> map) {
		int[] in = indegree(map);
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 0)
				q.add(i);
		}

		int count = 0;
		while (!q.isEmpty()) {
			int rem = q.poll();

			count += 1;
			for (int neighbour : map.get(rem)) {
				in [neighbour]--;
				if (in[neighbour] == 0)
					q.add(neighbour);

			}
		}

		return count == map.size();
	}

	public int[] indegree (Map<Integer, List<Integer>> map) {
		int[] in = new int[map.size()];

		for (int key : map.keySet())
			for (int neighbour : map.get(key))
				in [neighbour]++;

		return in;
	}
}