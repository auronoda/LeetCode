class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int[] diags = new int[2];
        int diff = 0;
        boolean xwin = false;
        boolean owin = false;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cur;
                if (board[i].charAt(j) == ' ') {
                    continue;
                }
                if (board[i].charAt(j) == 'X') {
                    cur = 1;
                }
                else {
                    cur = -1;
                }
                
                diff += cur;
                
                
                rows[i] += cur;
                if (rows[i] == 3) {
                    if (owin) {
                        return false;
                    }
                    xwin = true;
                }
                if (rows[i] == -3) {
                    if (xwin) {
                        return false;
                    }
                    owin = true;
                }
                cols[j] += cur;
                if (cols[j] == 3) {
                    if (owin) {
                        return false;
                    }
                    xwin = true;
                }
                if (cols[j] == -3) {
                    if (xwin) {
                        return false;
                    }
                    owin = true;
                }
                if (i == j) {
                    diags[0] += cur;
                    if (diags[0] == 3) {
                        if (owin) {
                            return false;
                        }
                        xwin = true;
                    }
                    if (diags[0] == -3) {
                        if (xwin) {
                            return false;
                        }
                        owin = true;
                    }
                }                
                if (i + j == 2) {
                    diags[1] += cur;
                    if (diags[1] == 3) {
                        if (owin) {
                            return false;
                        }
                        xwin = true;
                    }
                    if (diags[1] == -3) {
                        if (xwin) {
                            return false;
                        }
                        owin = true;
                    }
                }
            }
        }
        if ((xwin && diff == 0) || (owin && diff == 1)) {
            return false;
        }

        return (diff == 0 || diff == 1) && (!xwin || !owin);
    }
}
