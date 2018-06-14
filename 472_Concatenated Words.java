class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        TrieNode trie = new TrieNode();
        List<String> res = new ArrayList<>();
        for (String cur: words) {
            if (cur.length() == 0) {
                continue;
            }
            if (dfs(cur, trie, 0, 0)) {
                res.add(cur);
            }
            add(trie, cur);
        }
        
        return res;
    }
    
    private boolean dfs(String s, TrieNode root, int i, int count) {
        TrieNode cur = root;
        for (int j = i; j < s.length(); ++j) {
            char c = s.charAt(j);
            if (cur.chars[c - 'a'] == null) {
                return false;
            }
            cur = cur.chars[c - 'a'];
            
            if (cur.isWord) {
                if (j == s.length() - 1 && count > 0) {
                    return true;
                }
                if (dfs(s, root, j + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private class TrieNode {
        TrieNode[] chars;
        boolean isWord;
        TrieNode(){
            chars = new TrieNode[26];
            isWord = false;
        }
    }
    
    private void add(TrieNode root, String cur) {
        for (char c: cur.toCharArray()) {
            if (root.chars[c - 'a'] == null) {
                root.chars[c - 'a'] = new TrieNode();
            }
            root = root.chars[c - 'a'];
        }
        root.isWord = true;
    }
}
