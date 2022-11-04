class Solution {
    public String reverseVowels(String str) {
        int fp = 0;
        int lp = str.length() - 1;
        
        String vowel = "aeiouAEIOU";
        char[] s = str.toCharArray();
        
        while (fp < lp) {
            while(vowel.indexOf(s[fp]) < 0 && fp < lp)
                fp ++;

            while(vowel.indexOf(s[lp]) < 0 && fp < lp)
                lp --;
            
            if (fp < lp) {
                char temp = s[fp];
                s[fp] = s[lp];
                s[lp] = temp;
            }

            fp ++;
            lp --;
        }
        
        return new String(s);
    }
}