class Solution {
    public String removeOuterParentheses(String s) {
        String res = "";
        String curr = "";
        int count = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            count += c == '(' ? 1 : -1;
            if (count == 0) {
                res += curr.substring(1);
                curr = "";
            }
            else
                curr += c;            
        }
        
        return res;
    }
}