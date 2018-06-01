class Solution {
    
    private class TrieNode {
        TrieNode[] chars;
        int index;
        List<Integer> list;
        
        TrieNode() {
            chars = new TrieNode[26];
            index = -1;
            list = new LinkedList<>();
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; ++i) {
            add(root, words[i], i);
        }
        for (int i = 0; i < words.length; ++i) {
            search(root, words[i], i, res);
        }
        return res;
    }
    
    private void add(TrieNode root, String s, int index) {
        if (isPalindrome(s, 0, s.length() - 1)) {
            root.list.add(index);
        }
        TrieNode cur = root;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (cur.chars[c - 'a'] == null) {
                cur.chars[c - 'a'] = new TrieNode();
            }
            cur = cur.chars[c - 'a'];
            if (isPalindrome(s, i + 1, s.length() - 1)) {
                cur.list.add(index);
            }
        }
        cur.index = index;
    }
    
    private void search(TrieNode root, String s, int index, List<List<Integer>> res) {
        if (root.index != -1 && root.index != index && isPalindrome(s, 0, s.length() - 1)) {
            res.add(Arrays.asList(root.index, index));
        }
        TrieNode cur = root;        
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (cur.chars[c - 'a'] == null) {
                return;
            }
            cur = cur.chars[c - 'a'];
            if (cur.index != -1 && cur.index != index && isPalindrome(s, 0, i - 1)) {
                res.add(Arrays.asList(cur.index, index));
            }
        }
        for (int j: cur.list) {
            res.add(Arrays.asList(j, index));
        }
        if (cur.index != -1 && cur.index != index) {
            res.add(Arrays.asList(cur.index, index));
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
