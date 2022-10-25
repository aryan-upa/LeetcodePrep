class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int idx = 0;
        
        String s1 = "";
        String s2 = "";
        
        while (i < word1.length || j < word2.length) {
            if (i < word1.length) s1 += word1[i++];
            if (j < word2.length) s2 += word2[j++];
            
            while (idx < s1.length() && idx < s2.length()) {
                if (s1.charAt(idx) != s2.charAt(idx))
                    return false;
                idx ++;
            }
        }
        
        if (s1.length() != s2.length())
            return false;
        
        return true;
    }
}