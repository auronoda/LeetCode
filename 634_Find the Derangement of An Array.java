class Solution {
    public int findDerangement(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 2; i <= n; ++i) {
            double tmp = (i - 1) * (double)(dp[i - 1] + dp[i - 2]);
            dp[i] = (int)(tmp % 1000000007);
        }
        
        return dp[n];
    }
}
