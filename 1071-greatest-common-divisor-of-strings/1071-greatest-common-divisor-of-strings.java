class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String gcd = "";
        String ans = "";
        
        int l1 = str1.length();
        int l2 = str2.length();
        
        int minLen = l1 < l2 ? l1 : l2;
        int i = 0;
        
        while (i < minLen && str1.charAt(i) == str2.charAt(i)) {
            gcd += str1.charAt(i);
            int gcdLen = i + 1;
            
            if (l1%gcdLen == 0 && l2%gcdLen == 0) {
                if (gcd.repeat(l1/gcdLen).equals(str1) && gcd.repeat(l2/gcdLen).equals(str2))
                    ans = gcd;
            }
            
            i += 1;
        }
        
        return ans;
    }
}