class Solution {
    private class TrieNode {
        TrieNode[] chars;
        List<String> startsWith;
        
        TrieNode() {
            chars = new TrieNode[26];
            startsWith = new LinkedList<>();
        }
    }
    
    private class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        void add(String s) {
            TrieNode cur = root;
            cur.startsWith.add(s);
            for (int i = 0; i < s.length(); ++i) {
                if (cur.chars[s.charAt(i) - 'a'] == null) {
                    cur.chars[s.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.chars[s.charAt(i) - 'a'];
                cur.startsWith.add(s);
            }
        }
        
        List<String> search(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); ++i) {
                if (cur.chars[s.charAt(i) - 'a'] == null) {
                    return new ArrayList<>();
                }
                cur = cur.chars[s.charAt(i) - 'a'];
            }
            return cur.startsWith;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Trie trie = new Trie();
        int k = words[0].length();
        
        for (String s: words) {
            trie.add(s);
        }
        
        dfs(trie, res, list, "", k, 0);
        return res;
    }
    
    private void dfs(Trie trie, List<List<String>> res, List<String> list, String pre, int k, int i) {
        for (String s: trie.search(pre)) {
            list.add(s);
            if (i == k - 1) {
                res.add(new ArrayList<>(list));
                list.remove(i);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (String s2: list) {
                sb.append(s2.charAt(i + 1));
            }
            dfs(trie, res, list, sb.toString(), k, i + 1);
            list.remove(i);
        }
    }
    
    
}
