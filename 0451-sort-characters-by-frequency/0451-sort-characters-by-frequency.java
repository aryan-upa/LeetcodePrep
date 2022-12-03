class Pair {
	char c;
	int cnt;

	Pair (char c, int cnt) {
		this.c = c;
		this.cnt = cnt;
	}
}

class Solution {    
    public String frequencySort(String s) {
		ArrayList<Pair> freq = new ArrayList<>();
		{
			int[] arr = new int[256];
			for (int i = 0; i < s.length(); i ++)
				arr[s.charAt(i)] ++; // O(n)

			int j = 0;
			for (int i = 0; i < 256; i ++) {
				if (arr[i] == 0) continue;
				freq.add(new Pair((char) i, arr[i])); // constant time to add item in list.
			}
		}

		Pair[] arr = freq.toArray(new Pair[]{});
		Arrays.sort(arr, Comparator.comparingInt(o -> o.cnt)); // O(p*log(p)) p -> number of unique character in s (at max 52log52.)

		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i --)
			sb.append(("" + arr[i].c).repeat(arr[i].cnt));

		return sb.toString();
	}

    // with this I think it is safe to say that at the far end, this program runs in linear time wrt to input string size.
}