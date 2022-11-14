class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        
        long val = 1, row = rowIndex;
        long st = 0;
        while (st < (rowIndex + 1)) {
            list.add((int) val);
            val = val * (row - st) / (st + 1);
            st++;
        }

        return list;
    }
}