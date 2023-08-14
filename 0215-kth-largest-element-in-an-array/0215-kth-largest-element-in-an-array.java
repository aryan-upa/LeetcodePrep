class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums) list.add(num);
        return getMid (list, k);
    }
    
    public int getMid (List<Integer> list, int k) {
        if (list.size() == 1)
            return list.get(0);
        
        List<Integer> 
            left = new ArrayList<>(), 
            right = new ArrayList<>(), 
            mid = new ArrayList<>();
        
        int pivot = list.get(list.size() / 2);
        
        for (int el : list) {
            if (el > pivot) left.add(el);
            else if (el == pivot) mid.add(el);
            else right.add(el);
        }
        
        if (left.size() >= k)
            return getMid (left, k);
        else if (left.size() + mid.size() < k)
            return getMid (right, k - left.size() - mid.size());
        else
            return pivot;
    }
}