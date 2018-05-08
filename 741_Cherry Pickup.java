class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[2 * n - 1][n][n];
        dp[0][0][0] = grid[0][0];
        for (int i = 1; i < 2 * n - 1; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int p = 0; p < n; ++p) {
                    int k = i - j, q = i - p;
                    if (k < 0 || k >= n || q < 0 || q >= n || grid[j][k] < 0 || grid[p][q] < 0) {
                        dp[i][j][p] = -1;
                        continue;
                    }
                    dp[i][j][p] = dp[i - 1][j][p];
                    if (j > 0) {
                        dp[i][j][p] = Math.max(dp[i - 1][j - 1][p], dp[i][j][p]);
                    }
                    if (p > 0) {
                        dp[i][j][p] = Math.max(dp[i - 1][j][p - 1], dp[i][j][p]);
                    }
                    if (j > 0 && p > 0) {
                        dp[i][j][p] = Math.max(dp[i - 1][j - 1][p - 1], dp[i][j][p]);
                    }
                    if (dp[i][j][p] == -1) {
                        continue;
                    }
                    dp[i][j][p] += grid[j][k];
                    if (j != p) {
                        dp[i][j][p] += grid[p][q];
                    }
                }
            }
        }
        return dp[2 * n - 2][n - 1][n - 1] == -1? 0: dp[2 * n - 2][n - 1][n - 1];
    }
}
