class Solution {
    public boolean isGCDAble (String s1, String s2) {
        return !(s1 + s2).equals(s2 + s1);
    }
    
    public int gcd (int a, int b) {
        return b == 0 ? a : gcd (b, a % b);
    }
    
    public String gcdOfStrings(String str1, String str2) {
        if (isGCDAble(str1, str2))
            return "";
        
        int gcdLen = gcd (str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }
}