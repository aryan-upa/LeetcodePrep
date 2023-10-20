public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext())
            return null;

        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }

        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        int pos = nestedList.size() - 1;
        
        while (pos >= 0)
            stack.push(nestedList.get(pos --));        
    }
}