/*
    Why are we using stack here?
    We are using stack here because:
        1. we are maintaining the sequence of the records and keeping the last one handy.
        2. we are always looking on the left the of the input and thus we never have to look for the 
            upcoming operations beforehand.
*/

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("D"))
                stack.push(stack.peek()*2);
            else if (op.equals("C"))
                stack.pop();
            else if (op.equals("+")) {
                int num1 = stack.pop();
                int s = num1 + stack.peek();
                stack.push(num1);
                stack.push(s);
            }
            else
                stack.push(Integer.valueOf(op));
        }
        
        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        
        return sum;
    }
}