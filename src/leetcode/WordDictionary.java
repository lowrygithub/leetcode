package leetcode;
class TrieNode2{
    boolean isWord;
    TrieNode2[] childs;
    public TrieNode2() {
        isWord = false;
        childs = new TrieNode2[26];
    }
    public boolean search(String word){
        if(word.length()==0){
            return this.isWord;
        }
        else{
            if(word.charAt(0)!='.'){
                int letterIndex = word.charAt(0)-'a';
                TrieNode2 child =this.childs[letterIndex];
                if(child == null)
                    return false;
                else
                    return child.search(word.substring(1));
            }
            else{
                for(int i=0;i<26;i++){
                    TrieNode2 child =this.childs[i];
                    if(child!=null&&child.search(word.substring(1))){
                        return true;
                    }
                }
                return false;
            }
        }
    }
    public void addWord(String word){
        if(word.length()!=0){
            int letterIndex = word.charAt(0)-'a';
            TrieNode2 child = this.childs[letterIndex];
            if(child == null){
                TrieNode2 newNode = new TrieNode2();
                this.childs[letterIndex] = newNode;
                child = newNode;
            }
            child.addWord(word.substring(1));
        }
        else
            this.isWord = true;
    }
}
public class WordDictionary {
    private TrieNode2 root;
    public WordDictionary(){
        root = new TrieNode2();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
       this.root.addWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return this.root.search(word);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");