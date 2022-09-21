class Trie {

    class Node {
        public char ch;
        public boolean isword;
        public Node[] childrens;
        
        public Node(char ch) {
            this.ch = ch;
            isword = false;
            childrens = new Node[26]; // for 26 alphabets
        }
    }
    
    public Node root;
    
    public Trie() {
        root = new Node('0');        
    }
    
    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.childrens[c - 'a'] == null)
                curr.childrens[c - 'a'] = new Node(c);
            
            curr = curr.childrens[c - 'a'];
        }
        curr.isword = true;
    }
    
    public boolean search(String word) {
        Node found = getNode(word);
        if (found == null) return false;
        return found.isword;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    private Node getNode(String word) {
        Node curr = root;
        
        for (char c : word.toCharArray()) {
            if (curr.childrens[c - 'a'] == null)
                return null;
            
            curr = curr.childrens[c - 'a'];
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */