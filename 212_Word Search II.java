class Solution {
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode trie = new TrieNode();
        for (String word: words) {
            add(trie, word);
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                visited[i][j] = true;
                dfs(board, i, j, trie, res, visited); 
                visited[i][j] = false;
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode trie, List<String> res, boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if (trie.chars[board[i][j] - 'a'] == null) {
            return;
        }        
        trie = trie.chars[board[i][j] - 'a'];
        if (trie.word != null) {
            res.add(trie.word);
            trie.word = null;
        }
        
        for (int[] d: dir) {
            int r = i + d[0];
            int c = j + d[1];
            if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
                continue;                
            }
            visited[r][c] = true;
            dfs(board, r, c, trie, res, visited);
            visited[r][c] = false;
        }
    }
    
    private class TrieNode {
        TrieNode[] chars;
        String word;
        TrieNode(){
            chars = new TrieNode[26];
            word = null;
        }
    }
    
    private void add(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.chars[c - 'a'] == null) {
                cur.chars[c - 'a'] = new TrieNode();
            }
            cur = cur.chars[c - 'a'];
        }
        
        cur.word = word;
    }
}
