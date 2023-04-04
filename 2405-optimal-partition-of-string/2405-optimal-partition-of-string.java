class Solution {
    public int partitionString(String s) {
        int[] chars = new int[26];
        int i = 0;
        int e = 0;
        int stringCount = 0;
        
        while (e < s.length()) {
            chars[s.charAt(e) - 97] += 1;
            
            if (chars[s.charAt(e) - 97] > 1) {
                chars = new int[26];
                stringCount += 1;
                chars[s.charAt(e) - 97] += 1;
                i = e;
            }
            
            e += 1;
        }
        
        if (i != e)
            stringCount += 1;
        
        return stringCount;
    }
}