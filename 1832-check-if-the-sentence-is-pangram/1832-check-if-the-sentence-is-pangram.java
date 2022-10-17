class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] isPresent = new boolean[26];
        int len = sentence.length();
        for (int i = 0; i < len; i ++) {
            if (!isPresent[sentence.charAt(i) - 'a'])
                isPresent[sentence.charAt(i) - 'a'] = true;
        }
        
        for (int i = 0; i < 26; i ++)
            if (!isPresent[i])
                return false;
        
        return true;
    }
}