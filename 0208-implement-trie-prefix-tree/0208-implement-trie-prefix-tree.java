class TrieNode{
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord = false;
}
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currNode = root;
        char[] arr = word.toCharArray();
        for(char currChar : arr){
            if(currNode.children.containsKey(currChar) == false){
                currNode.children.put(currChar, new TrieNode());
            }
            currNode = currNode.children.get(currChar);
        }
        currNode.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode currNode = root;
        char[] arr = word.toCharArray();
        for(char currChar : arr){
            if(currNode.children.containsKey(currChar) == false){
                return false;
            }
            currNode = currNode.children.get(currChar);
        }
        return currNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        char[] arr = prefix.toCharArray();
        for(char currChar : arr){
            if(currNode.children.containsKey(currChar) == false){
                return false;
            }
            currNode = currNode.children.get(currChar);
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