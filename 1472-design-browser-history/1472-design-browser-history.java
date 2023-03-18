class HistoryNode {
	String url;
	HistoryNode next;
	HistoryNode prev;
	
	HistoryNode (String url) {
		this.url = url;
	}
}

class BrowserHistory {

	private HistoryNode curr;

	public BrowserHistory (String homepage) {
		curr = new HistoryNode(homepage);
	}

	public void visit(String url) {
		HistoryNode newNode = new HistoryNode (url);
		
		curr.next = newNode;
		newNode.prev = curr;
		curr = curr.next;
	}

	public String back (int steps) {
		HistoryNode trav = curr;
		while (steps -- > 0 && trav.prev != null)
			trav = trav.prev;
		
		curr = trav;
		return curr.url;
	}

	public String forward(int steps) {
		HistoryNode trav = curr;
		while (steps -- > 0 && trav.next != null)
			trav = trav.next;
		
		curr = trav;
		return curr.url;
	}
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */