class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        char[] res = new char[l1 + l2];
                
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < l1 && j < l2) {
            res[k] = word1.charAt(i);
            res[k + 1] = word2.charAt(j);
            i += 1;
            j += 1;
            k += 2;
        }
        
        if (i < l1)
            while (k < l1 + l2)
                res[k++] = word1.charAt(i++);

        if (j < l2)
            while (k < l1 + l2)
                res[k++] = word2.charAt(j++);
        
        return new String(res);
    }
}