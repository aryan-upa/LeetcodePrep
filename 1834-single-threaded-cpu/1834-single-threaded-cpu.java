class Solution {
	static class Task {
		int id;
		int et;
		int pt;

		Task(int id, int et, int pt) {
			this.id = id;
			this.et = et;
			this.pt = pt;
		}
	}

	public int[] getOrder(int[][] tasks) {
		int[] ans = new int[tasks.length];

		PriorityQueue<Task> pq = new PriorityQueue<> ((a, b) -> a.pt == b.pt ? a.id - b.id : a.pt - b.pt);
		Queue<Task> pending;

		{
			List<Task> list = new ArrayList<>();

			for (int i = 0; i < tasks.length; i++)
				list.add(new Task(i, tasks[i][0], tasks[i][1]));

			list.sort(Comparator.comparingInt(a -> a.et));
			pending = new LinkedList<>(list);
		}

		int completion = 0;
		int time = 0;
		while (!(pending.isEmpty() && pq.isEmpty())) {
			while( !pending.isEmpty() && pending.peek().et <= time)
				pq.add( pending.poll() );

			if (pq.isEmpty() && !pending.isEmpty()) {
				time = pending.peek().et;
				continue;
			}

			Task taskToProcess = pq.poll();
			assert taskToProcess != null;
			time = time + taskToProcess.pt;
			ans[completion++] = taskToProcess.id;
		}

		return ans;
	}
}