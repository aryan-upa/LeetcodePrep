class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] allNums = new int[1000];

        int pos = 0;
        int val = 1;

        int arPos = 0;
        while (pos < k && arPos < arr.length) {
            if (arr[arPos] != val)
                allNums[pos++] = val++;
            else {
                val = arr[arPos] + 1;
                arPos++;
            }
        }

        if (arPos == arr.length) {
            val = arr[arPos-1] + 1;
            while (pos < k) {
                allNums[pos++] = val++;
            }
        }

        // System.out.println(Arrays.toString(allNums));
        return allNums[pos-1];
    }

}