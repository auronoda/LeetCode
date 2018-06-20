class Solution {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            if (S.charAt(i) == T.charAt(0)) {
                dp[i][0] = i;
                
            }
            else {
                dp[i][0] = -1;
            }
        }
        
        for (int j = 1; j < n; ++j) {
            int k = -1;
            for (int i = 0; i < m; ++i) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = k;
                }
                else {
                    dp[i][j] = -1;
                }
                
                k = Math.max(k, dp[i][j - 1]);
            }
        }
        int start = -1;
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            if (dp[i][n - 1] != -1 && l > i - dp[i][n - 1] + 1) {
                start = dp[i][n - 1];
                l = i - dp[i][n - 1] + 1;
            }
        }

        return start != -1? S.substring(start, start + l): "";
    }
}
