class AutocompleteSystem {
    
    private class Node {
        String s;
        int count;
        Node(String s, int c) {
            this.s = s;
            count = c;
        }
    }
    
    private class Trie {
        int count;
        Trie[] chars;
        Trie() {
            count = 0;
            chars = new Trie[27];
        }
    }
    
    Trie root;
    String curS;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        curS = "";
        for (int i = 0; i < sentences.length; ++i) {
            add(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<Node> tmp = new ArrayList<>();
        List<String> res = new LinkedList<>();
        if (c == '#') {
            add(curS, 1);
            curS = "";
            return res;
        }
        
        else {
            curS = curS + c;
            search(curS, tmp);
            Collections.sort(tmp, new Comparator<Node>(){
                public int compare(Node a, Node b) {
                    if (a.count == b.count) {
                        return a.s.compareTo(b.s);
                    }
                    return b.count - a.count;
                }
            });
            for (int i = 0; i < Math.min(3, tmp.size()); ++i) {
                res.add(tmp.get(i).s);
            }
            return res;
        } 
    }
    
    private void add(String s, int count) {
        Trie cur = root;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (cur.chars[26] == null) {
                    cur.chars[26] = new Trie();
                }
                cur = cur.chars[26];
            }
            else {
                if (cur.chars[c - 'a'] == null) {
                    cur.chars[c - 'a'] = new Trie();
                }
                cur = cur.chars[c - 'a'];
            }
        }
        
        cur.count += count;
    }
    
    private void search(String s, List<Node> list) {
        Trie cur = root;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (cur.chars[26] == null) {
                    return;
                }
                cur = cur.chars[26];
            }
            else {
                if (cur.chars[c - 'a'] == null) {
                    return;
                }
                cur = cur.chars[c - 'a'];
            }
        }
        
        dfs(cur, s, list);
    }
    
    private void dfs(Trie cur, String s, List<Node> list) {
        if (cur.count != 0) {
            list.add(new Node(s, cur.count));
        }
        if (cur.chars[26] != null) {
            dfs(cur.chars[26], s + ' ', list);
        }
        for (int i = 0; i < 26; ++i) {
            if (cur.chars[i] != null) {
                dfs(cur.chars[i], s + (char)('a' + i), list);
            }
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
