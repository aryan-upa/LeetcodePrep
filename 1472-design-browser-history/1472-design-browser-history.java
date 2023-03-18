class BrowserHistory {

    private ArrayList<String> history;
    private int pos;
    private int boundary;
    
    public BrowserHistory (String homepage) {
        history = new ArrayList<>();
        
        history.add(homepage);
        pos = 0;
        boundary = pos + 1;
    }
    
    public void visit(String url) {
        if (pos + 1 == history.size())
            history.add(url);
        else
            history.set(pos + 1, url);
        
        pos += 1;
        boundary = pos + 1;
    }
    
    public String back(int steps) {
        if (steps > pos)
            steps = pos;
        
        pos = pos - steps;
        return history.get(pos);
    }
    
    public String forward(int steps) {
        if (steps > boundary - pos - 1)
            steps = boundary - pos - 1;
        
        pos = steps + pos;
        return history.get(pos);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */