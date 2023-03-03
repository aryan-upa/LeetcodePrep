class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        
        else if (haystack.equals(""))
            return -1;
        
        else {
            int hLen = haystack.length(), nLen = needle.length();
            int curr, pos;

            boolean isFound = false;
            for (int i = 0; i < hLen; i++) {
                if (haystack.charAt(i) != needle.charAt(0))
                    continue;
                
                curr = i;
                pos = 0;
                while(++pos < nLen && ++i < hLen)
                    if (haystack.charAt(i) != needle.charAt(pos))
                        break;
                i = curr;
                
                if (pos == nLen)
                    isFound = true;
                
                if (isFound)
                    return curr;
            }
            
            return -1;
        }
    }
}