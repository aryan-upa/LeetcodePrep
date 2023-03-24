class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < numCourses; i ++)
			map.put(i, new ArrayList<>());

		for (int[] edge : prerequisites)
			map.get(edge[1]).add(edge[0]);

		return findOrdering (map);
	}

	public int[] findOrdering (Map<Integer, List<Integer>> map) {
		int[] inorder = inorder(map);
		int node = map.size();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < inorder.length; i ++)
			if (inorder[i] == 0)
				queue.add(i);
		
		int[] seq = new int[map.size()];
		int count = 0;
		while (!queue.isEmpty()) {
			int rem = queue.remove();

			seq [count] = rem;
			count += 1;
			for (int nbh : map.get(rem)) {
				inorder [nbh] -= 1;
				if (inorder [nbh] == 0)
					queue.add(nbh);
			}
		}

		return count == map.size() ? seq : new int[]{};
	}

	public int[] inorder (Map<Integer, List<Integer>> map) {
		int[] in = new int[map.size()];

		for (int key : map.keySet())
			for (int val : map.get(key))
				in[val] += 1;

		return in;
	}
}