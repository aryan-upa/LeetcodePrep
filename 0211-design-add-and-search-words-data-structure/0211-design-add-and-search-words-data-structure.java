class Word {
    Map<Character, Word> children;
    boolean isWord;
    
    Word () {
        children = new HashMap<>(26);
        isWord = false;
    }
}

class WordDictionary {

    Word root;
    
    public WordDictionary() {
        root = new Word();
    }
    
    public void addWord (String word) {
        Word curr = root;
        
        for (char c : word.toCharArray())
            curr = curr.children.computeIfAbsent(c, ch -> new Word());
        
        curr.isWord = true;
    }
    
    public boolean search (String word) {
        return searchHelper (word.toCharArray(), root, 0);
    }
    
    private boolean searchHelper (char[] word, Word node, int idx) {
        if (node == null)
            return false;

        if (idx == word.length)
            return node.isWord;
        
        if (word[idx] == '.') {
            for (int i = 0; i < 26; i ++)
                if (searchHelper(word, node.children.get((char) ('a' + i)), idx + 1))
                    return true;
            return false;
        }
        
        return searchHelper (word, node.children.get(word[idx]), idx + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */