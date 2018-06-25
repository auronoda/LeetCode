class WordDictionary {
    
    private class Trie {
        Trie[] chars;
        boolean isWord;
        Trie() {
            chars = new Trie[26];
            isWord = false;
        }
    }
    
    private Trie trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie cur = trie;
        for (char c: word.toCharArray()) {
            if (cur.chars[c - 'a'] == null) {
                cur.chars[c - 'a'] = new Trie();
            }
            cur = cur.chars[c - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(trie, word, 0);
    }
    
    private boolean helper(Trie cur, String word, int idx) {
        if (idx == word.length()) {
            return cur.isWord;
        }
        
        char c = word.charAt(idx);
        if (c == '.') {
            for (Trie next: cur.chars) {
                if (next != null) {
                    if (helper(next, word, idx + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
        else {
            if (cur.chars[c - 'a'] == null) {
                return false;
            }
            return helper(cur.chars[c - 'a'], word, idx + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
