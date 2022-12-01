class Solution {
    public String removeOuterParentheses(String s) {
        String res = "";
        String curr = "";
        int count = 0;
        
        for (char c : s.toCharArray()) {
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