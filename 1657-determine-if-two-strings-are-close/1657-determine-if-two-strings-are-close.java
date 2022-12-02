class Solution {
    public boolean closeStrings(String word1, String word2) {
        /*
            Fraz bro solution:
            
            The idea is:
                two strings are close if unique characters in both the strings are same and count of 
                characters in both the strings are same.
        */
        
        int l1 = word1.length(), l2 = word2.length();
        if (l1 != l2)
            return false;
        
        int[] set = new int[26];
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        char c;
        for (int i = 0; i < l1; i++) {
            c = word1.charAt(i);
            
            set[c - 'a'] = 1;
            count1[c - 'a']++;

            c = word2.charAt(i);
            count2[c - 'a']++;            
        }
        
        for (int i = 0; i < l2; i++) {
            if (set[word2.charAt(i) - 'a'] == 0) return false;            
        }
        
        Arrays.sort(count1);
        Arrays.sort(count2);
        
        for (int i = 0; i < 26; i ++)
            if (count1[i] != count2[i])
                return false;
        
        return true;        
    }
}