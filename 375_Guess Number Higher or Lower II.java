class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int j = 1; j < n; ++j) {
            for (int i = 1; i + j <= n; ++i) {
                int min = Integer.MAX_VALUE;
                for (int cur = i; cur <= i + j; ++cur) {
                    min = Math.min(min, cur + Math.max(dp[i][cur - 1], dp[cur + 1][i + j]));
                }
                dp[i][i + j] = min;
            }
        }
        return dp[1][n];
    }
}
