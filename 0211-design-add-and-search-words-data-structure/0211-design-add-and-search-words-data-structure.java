class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}
class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();    
    }
    
    public void addWord(String word) {
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
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int index, TrieNode node) {
        if(index == word.length()) {
            return node.isWord;
        }
        
        char currChar = word.charAt(index);
        
        if(currChar == '.') {
            for(TrieNode child : node.children.values()) {
                if(searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        
        if(!node.children.containsKey(currChar)) {
            return false;
        }
        
        return searchHelper(word, index + 1, node.children.get(currChar));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */