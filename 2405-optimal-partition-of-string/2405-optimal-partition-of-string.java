class Solution {
    public int partitionString(String s) {
        char[] ch = s.toCharArray();
        int[] chars = new int[26];
        int i = 0;
        int e = 0;
        int stringCount = 0;
        
        while (e < ch.length) {
            chars[ch[e] - 97] += 1;
            
            if (chars[ch[e] - 97] > 1) {
                chars = new int[26];
                stringCount += 1;
                chars[ch[e] - 97] += 1;
                i = e;
            }
            
            e += 1;
        }
        
        if (i!=e)
            stringCount += 1;
        
        return stringCount;
    }
}