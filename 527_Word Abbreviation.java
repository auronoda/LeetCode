class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        String[] res = new String[dict.size()];
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <dict.size(); ++i) {
            String cur = dict.get(i);
            String key = minAbbr(cur);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
        }
        
        for (List<Integer> group: map.values()) {
            Trie trie = new Trie();
            for (int idx: group) {
                add(trie, dict.get(idx));
            }
            for (int idx: group) {
                int i = search(trie, dict.get(idx));
                res[idx] = (abbr(dict.get(idx), i));
            }
        }
        
        return Arrays.asList(res);
    }
    
    private class Trie {
        Trie[] chars;
        int count;
        
        Trie(){
            chars = new Trie[26];
            count = 0;
        }
    }
    
    private String minAbbr(String cur) {
        if (cur.length() <= 3) {
            return cur;
        }
        return "" + cur.charAt(0) + (cur.length() - 2) + cur.charAt(cur.length() - 1);
    }
    
    private String abbr(String cur, int i) {
        if (i >= cur.length() - 3) {
            return cur;
        }
        return cur.substring(0, i + 1) + (cur.length() - i - 2) + cur.charAt(cur.length() - 1);
    }
    
    private void add(Trie root, String s) {
        Trie cur = root;
        for (char c: s.toCharArray()) {
            if (cur.chars[c - 'a'] == null) {
                cur.chars[c - 'a'] = new Trie();
            } 
            cur = cur.chars[c - 'a'];
            cur.count++;
        }
    }
    
    private int search(Trie root, String s) {
        Trie cur = root;
        for (int i = 0; i < s.length(); ++i) {
            cur = cur.chars[s.charAt(i) - 'a'];
            if (cur.count == 1) {
                return i;
            }
        }
        return -1;
    }
}
