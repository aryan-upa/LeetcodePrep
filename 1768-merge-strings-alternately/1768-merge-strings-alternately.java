class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        
        int l1 = word1.length(), l2 = word2.length();
        while (i < l1 && j < l2) {
            sb.append("" + word1.charAt(i) + word2.charAt(j));
            i += 1;
            j += 1;
        }
        
        if (i < l1)
            sb.append(word1.substring(i));
        
        if (j < l2)
            sb.append(word2.substring(j));
        
        return sb.toString();
    }
}