class Solution {
	static class CreatorData {
		ArrayList<Integer> views;
		ArrayList<String> ids;
		long viewSum;
		int maxView;

		CreatorData() {
			views = new ArrayList<>();
			ids = new ArrayList<>();
			viewSum = 0;
			maxView = 0;

		}
	}

	public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
		Map<String, CreatorData> map = new HashMap<>();
		long maxViewOverall = 0;

		for (int i = 0; i < creators.length; i ++) {
			String creator = creators[i];
			if (!map.containsKey(creator))
				map.put(creator, new CreatorData());

			CreatorData data = map.get(creator);

			data.views.add(views[i]);
			data.ids.add(ids[i]);
			data.viewSum += views[i];
			data.maxView = data.maxView > views[i] ? data.maxView : views[i];

			maxViewOverall = maxViewOverall > data.viewSum ? maxViewOverall : data.viewSum;
		}

		List<List<String>> res = new ArrayList<>();

		for (String key : map.keySet()) {
			CreatorData data = map.get(key);
			if (data.viewSum != maxViewOverall)
				continue;
			ArrayList<String> val = new ArrayList<>();
			val.add(key);
			SortedSet<String> minID = new TreeSet<>();
			for (int i = 0; i < data.views.size(); i ++)
				if (data.views.get(i) == data.maxView)
					minID.add(data.ids.get(i));
			val.add(minID.first());
			res.add(val);
		}

		return res;
	}
}