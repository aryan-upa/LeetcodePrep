class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> mapCharIndex = new HashMap<>();
        char[] orderArr = order.toCharArray();
        
        for (int i = 0; i < orderArr.length; i ++)
            mapCharIndex.put(orderArr[i], i);
        
        for (int i = 1; i < words.length; i ++)
            if (!isLexicographicallySorted(words[i-1], words[i], mapCharIndex))
                return false;
        
        return true;
    }
    
    public boolean isLexicographicallySorted(String prev, String next, HashMap<Character, Integer> mapCharIndex) {
        int indexPrev = 0;
        int indexNext = 0;
        
        int prevLen = prev.length();
        int nextLen = next.length();

        while (indexPrev < prevLen && indexNext < nextLen) {
            if (prev.charAt(indexPrev) != next.charAt(indexNext))
                return mapCharIndex.get(prev.charAt(indexPrev)) < mapCharIndex.get(next.charAt(indexNext));
            
            indexPrev ++;
            indexNext ++;
        }
        
        return prev.equals(next) ? true : prevLen < nextLen;
    }
}