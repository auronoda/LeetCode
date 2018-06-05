class Solution {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        
        int m = board.length, n = board[0].length;
        boolean next = false;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = Math.abs(board[i][j]);
                if (v == 0) {
                    continue;
                }
                if (i < m - 2 && Math.abs(board[i + 1][j]) == v && Math.abs(board[i + 2][j]) == v) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                    next = true;
                }
                if (j < n - 2 && Math.abs(board[i][j + 1]) == v && Math.abs(board[i][j + 2]) == v) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                    next = true;
                }
            }
        }
        
        if (!next) {
            return board;
        }
        
        for (int c = 0; c < n; ++c) {
            int fast = m - 1, slow = m - 1;
            while (fast >= 0) {
                while (fast >= 0 && board[fast][c] <= 0) {
                    fast--;
                }
                if (fast >= 0) {
                    board[slow--][c] = board[fast--][c];
                }                
            }
            while (slow >= 0) {
                board[slow--][c] = 0;
            }
        }
        
        return candyCrush(board);
    }
}
