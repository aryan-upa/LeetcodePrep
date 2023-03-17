class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    
    TrieNode () {
        children = new TreeMap<>();
        isWord = false;
    }
}

class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for (char ch : word.toCharArray())
            curr = curr.children.computeIfAbsent(ch, c -> new TrieNode());
        
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for (char ch : word.toCharArray()) {
            curr = curr.children.get(ch);            
            if (curr == null)
                return false;
        }
        
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for (char ch : prefix.toCharArray()) {
            curr = curr.children.get(ch);            
            if (curr == null)
                return false;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */