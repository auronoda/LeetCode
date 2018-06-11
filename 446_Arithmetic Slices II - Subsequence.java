class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        Map<Long, Integer>[] dp = new Map[n];
        int res = 0;
        
        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                long diff = (long)A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 0) + 1 + dp[i].getOrDefault(diff, 0));
                res += dp[j].getOrDefault(diff, 0);
            }
        }
        
        return res;
    }
}
