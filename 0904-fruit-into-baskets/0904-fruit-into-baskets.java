class Solution {
    public int totalFruit(int[] fruits) {
		int start, end;
		start = end = 0;

		HashMap<Integer, Integer> fruitTypeAndCount = new HashMap<>();
		int maxBasket = 0;

		while (end < fruits.length) {
			if (!fruitTypeAndCount.containsKey(fruits[end]))
				fruitTypeAndCount.put(fruits[end], 0);

			fruitTypeAndCount.put(fruits[end], fruitTypeAndCount.get(fruits[end]) + 1);

			while (fruitTypeAndCount.keySet().size() > 2) {
				fruitTypeAndCount.put(fruits[start], fruitTypeAndCount.get(fruits[start]) - 1);
				if (fruitTypeAndCount.get(fruits[start]) == 0)
					fruitTypeAndCount.remove(fruits[start]);
				start += 1;
			}

			maxBasket = Math.max(maxBasket, end - start + 1);
			end ++;
		}

		return maxBasket;

    }
}