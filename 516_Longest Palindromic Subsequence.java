class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        
        for (int j = 1; j < n; ++j) {
            for (int i = 0; i + j < n; ++i) {
                if (chars[i] == chars[i + j]) {
                    dp[i][i + j] = dp[i + 1][i + j - 1] + 2;
                }
                else {
                    dp[i][i + j] = Math.max(dp[i + 1][i + j], dp[i][i + j - 1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}
