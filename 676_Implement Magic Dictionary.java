class MagicDictionary {
    private class node{
        node[] chars;
        boolean isWord;
        public node(){
            chars = new node[26];
        }
    }
    
    node root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new node();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word: dict) {
            node cur = root;
            for (int i = 0; i < word.length(); i++){
                if (cur.chars[word.charAt(i) - 'a'] == null){
                    cur.chars[word.charAt(i) - 'a'] = new node();
                }            
                cur = cur.chars[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - 'a';
            for (int j = 0; j < 26; j++) {
                if (c == j) {
                    continue;
                }
                chars[i] = (char)('a' + j);
                if (helper(new String(chars), root)) {
                    return true;
                }
            }
            chars[i] = (char)('a' + c);
        }
        return false;
    }
    
    private boolean helper(String word, node root) {
        node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.chars[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.chars[word.charAt(i) - 'a'];
        }
        return cur.isWord;
    }
}



/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
