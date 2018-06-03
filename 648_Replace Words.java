class Solution {
    private class TrieNode {
        TrieNode[] chars;
        boolean isWord;
        
        TrieNode() {
            chars = new TrieNode[26];
            isWord = false;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        TrieNode trie = new TrieNode();
        
        for (String s: dict) {
            add(trie, s);
        }
        for (String s: words) {
            sb.append(search(trie, s) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private void add(TrieNode root, String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (cur.chars[c - 'a'] == null) {
                cur.chars[c - 'a'] = new TrieNode();
            }
            cur = cur.chars[c - 'a'];
        }
        cur.isWord = true;
    }
    
    private String search(TrieNode root, String s) {
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (cur.chars[c - 'a'] == null) {
                return s;
            }
            cur = cur.chars[c - 'a'];
            sb.append(c);
            if (cur.isWord) {
                return sb.toString();
            }
        }
        return s;
    }
}
