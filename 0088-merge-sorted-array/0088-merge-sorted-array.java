class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i ++)
            temp[i] = nums1[i];
        
        int i = 0, j = 0, k = 0;
        while (i < temp.length && j < nums2.length) {
            if (temp[i] < nums2[j])
                nums1[k] = temp[i ++];
            else
                nums1[k] = nums2[j ++];
            k ++;
        }
        
        while (i < temp.length)
            nums1[k++] = temp[i++];
        while (j < nums2.length)
            nums1[k++] = nums2[j++];
    }
}