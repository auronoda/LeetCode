class Solution {
    private class Trie {
        Trie[] chars;
        boolean isWord;
        Trie(){
            chars = new Trie[26];
            isWord = false;
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        for (String cur: words) {
            add(trie, cur);
        }
        List<String> res = new ArrayList<>();
        for (String cur: words) {
            if (dfs(trie, cur, 0, 0)) {
                res.add(cur);
            }
        }
        return res;
    }
    
    private void add(Trie trie, String s) {
        Trie cur = trie;
        for (char c: s.toCharArray()) {
            if (cur.chars[c - 'a'] == null) {
                cur.chars[c - 'a'] = new Trie();
            }
            cur = cur.chars[c - 'a'];
        }
        cur.isWord = true;
    }
    
    private boolean dfs(Trie trie, String s, int start, int count) {
        Trie cur = trie;
        for (int i = start; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (cur.chars[c - 'a'] == null) {
                return false;
            }
            cur = cur.chars[c - 'a'];
            if (cur.isWord) {
                if (i == s.length() - 1) {
                    return count > 0;
                }
                else {
                    if (dfs(trie, s, i + 1, count + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
