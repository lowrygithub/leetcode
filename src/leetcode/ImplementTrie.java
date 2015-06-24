package leetcode;

class TrieNode {
    boolean isWord;
    TrieNode[] childs;
    // Initialize your data structure here.
    public TrieNode() {
        isWord = false;
        childs = new TrieNode[26];
    }
}

public class ImplementTrie {
    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = this.root;
        for(char letter: word.toCharArray()){
        	if(node.childs[letter-'a']==null)
        		node.childs[letter-'a']=new TrieNode();
        	node=node.childs[letter-'a'];
        }
//        for(int i=0;i<word.length();i++){
//            int letterIndex = word.charAt(i)-'a';
//            TrieNode child = node.childs[letterIndex];
//            if(child == null){
//                TrieNode newNode = new TrieNode();
//                node.childs[letterIndex] = newNode;
//                node = newNode;
//            }
//            else{
//                node=child;
//            }
//        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = this.root;
        for(int i=0;i<word.length();i++){
            int letterIndex = word.charAt(i)-'a';
            TrieNode child = node.childs[letterIndex];
            if(child == null){
                return false;
            }
            else{
                node=child;
            }
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for(int i=0;i<prefix.length();i++){
            int letterIndex = prefix.charAt(i)-'a';
            TrieNode child = node.childs[letterIndex];
            if(child == null){
                return false;
            }
            else{
                node=child;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");