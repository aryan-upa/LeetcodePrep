class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1)
            return true;
        
        char[] s = word.toCharArray();
        if (s[0] >= 65 && s[0] < 97) {
            int min = s[1] >= 65 && s[1] <= 90 ? 65 : 97;
            int max = s[1] >= 65 && s[1] <= 90 ? 90 : 122;
            
            for (int i = 1; i < s.length; i ++)
                if (s[i] > max || s[i] < min)
                    return false;
        } else {
            for (int i = 1; i < s.length; i ++)
                if (!(s[i] >= 97 && s[i] <= 122))
                    return false;
        }
        
        return true;
    }
}