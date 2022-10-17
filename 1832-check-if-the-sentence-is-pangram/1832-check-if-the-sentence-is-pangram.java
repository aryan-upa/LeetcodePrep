class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] isPresent = new boolean[26];
        for (int i = 0; i < sentence.length(); i ++)
            isPresent[sentence.charAt(i) - 'a'] = true;
        
        for (int i = 0; i < 26; i ++)
            if (!isPresent[i])
                return false;
        
        return true;
    }
}