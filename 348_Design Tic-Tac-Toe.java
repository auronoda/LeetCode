class TicTacToe {
    
    int size;
    int[] rows;
    int[] cols;
    int[] diags;
    static int[] dir = new int[]{0, 1, -1};

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        cols = new int[n];
        diags = new int[2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += dir[player];
        if (rows[row] == size || rows[row] == -size) {
            return player;
        }
        cols[col] += dir[player];
        if (cols[col] == size || cols[col] == -size) {
            return player;
        }
        if (row == col) {
            diags[0] += dir[player];
            if (diags[0] == size || diags[0] == -size) {
                return player;
            }
        }
        if (row + col == size - 1) {
            diags[1] += dir[player];
            if (diags[1] == size || diags[1] == -size) {
                return player;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
