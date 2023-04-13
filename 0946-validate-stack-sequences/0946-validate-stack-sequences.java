class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pIdx = 0;
        
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && pIdx < pushed.length && stack.peek() == popped[pIdx]) {
                stack.pop();
                pIdx += 1;
            }
        }
        
        return pIdx == popped.length;
    }
}