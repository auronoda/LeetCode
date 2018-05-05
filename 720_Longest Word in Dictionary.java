class Solution {
    private class node{
        public node[] chars;
        public boolean isWord;
        public node(){
            chars = new node[26];
            isWord = false;
        }
    }
    public String longestWord(String[] words) {
        
        String res = "";
        node root = new node();
        Arrays.sort(words);
        for (String s: words) {
            node cur = root;
            root.isWord = true;
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.chars[c - 'a'] == null) {
                    cur.chars[c - 'a'] = new node();
                    if (cur.isWord && i == s.length() - 1) {
                        flag = true;
                        if (s.length() > res.length()) {
                            res = s;
                        }
                    }
                }
                cur = cur.chars[c - 'a'];
            }
            if (flag == true) {
                cur.isWord = true;
            }
        }
        return res;
    }
}
