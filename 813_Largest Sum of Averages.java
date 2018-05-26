class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[n + 1][K + 1];
        double sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += A[i - 1];
            dp[i][1] = sum / i;
        }
        for (int i = 2; i <= K; ++i) {
            for (int j = i; j <= n; ++j) {
                sum = 0;
                for (int k = j - 1; k >= i - 1; --k) {
                    sum += A[k];
                    dp[j][i] = Math.max(dp[j][i], dp[k][i - 1] + sum / (j - k));
                }
            }
        }
        return dp[n][K];
    }
}
