class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");        
        StringBuilder line = new StringBuilder();
        
        for (int i = 0; i < words.length - 1; i ++)
            line.append(new StringBuilder(words[i]).reverse().toString() + " ");
        
        line.append(new StringBuilder(words[words.length - 1]).reverse().toString());        
        return line.toString();
    }
}    
