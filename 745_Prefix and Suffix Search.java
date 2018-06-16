class WordFilter {
    TrieNode trie;

    public WordFilter(String[] words) {
        trie = new TrieNode();
        for (int i = 0; i < words.length; ++i) {
            String s = words[i];
            StringBuilder sb = new StringBuilder();
            sb.append('#').append(s);
            add(trie, sb.toString(), i);
            for (int j = s.length() - 1; j >= 0; --j) {
                sb.insert(0, s.charAt(j));
                add(trie, sb.toString(), i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return search(trie, suffix + '#' + prefix);
    }
    
    private void add(TrieNode trie, String s, int weight) {
        for (char c: s.toCharArray()) {
            int index;
            if (c == '#') {
                index = 26;
            }
            else {
                index = c - 'a';
            }
            if (trie.chars[index] == null) {
                trie.chars[index] = new TrieNode();
            }
            trie = trie.chars[index];
            trie.weight = weight;
        }
    }
    
    private int search(TrieNode trie, String s) {
        for (char c: s.toCharArray()) {
            int index;
            if (c == '#') {
                index = 26;
            }
            else {
                index = c - 'a';
            }
            if (trie.chars[index] == null) {
                return -1;
            }
            trie = trie.chars[index];
        }
        
        return trie.weight;
    }
    
    private class TrieNode {
        TrieNode[] chars;
        int weight;
        TrieNode() {
            chars = new TrieNode[27];
            weight = 0;
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
