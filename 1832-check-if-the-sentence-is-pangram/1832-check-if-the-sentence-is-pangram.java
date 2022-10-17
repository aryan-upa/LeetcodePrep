class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] isPresent = new boolean[26];
        int len = sentence.length();

        for (int i = 0; i < len; i ++)
            isPresent[sentence.charAt(i) - 97] = true;
        
        for (int i = 0; i < 26; i ++)
            if (!isPresent[i])
                return false;
        
        return true;
    }
}