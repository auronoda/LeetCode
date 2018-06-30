class Solution {
    public int findDerangement(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i <= n; ++i) {
            long tmp = (long)(i - 1) * (dp[i - 1] + dp[i - 2]) % 1000000007;
            dp[i] = (int)tmp;
        }
        return dp[n];
    }
}
