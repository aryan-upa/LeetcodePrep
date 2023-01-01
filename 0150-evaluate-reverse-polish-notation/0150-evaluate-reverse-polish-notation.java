class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> result = new Stack<Integer>();

        for (String t : tokens) {
            if (t.length() == 1 && (t.charAt(0) < '0' || t.charAt(0) > '9')) {
                int n2 = result.pop();
                int n1 = result.pop();
                int res = 0;
                
                switch(t.charAt(0)) {
                    case '+' : res = n1 + n2; break;
                    case '-' : res = n1 - n2; break;
                    case '*' : res = n1 * n2; break;
                    case '/' : res = n1 / n2; break;
                }

                result.push(res);
            } 
            else
                result.push(Integer.parseInt(t));
        }

        return result.peek();
    }
}