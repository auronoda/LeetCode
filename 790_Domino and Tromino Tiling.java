class Solution {
    public int numTilings(int N) {        
        if (N == 0) {
            return 0;
        }        
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        
        int mod = 1000000007;
        
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= N; ++i) {
            long tmp = 0;
            for (int j = 1; j < i; ++j) {
                tmp = (tmp + (j <= 2? 1: 2) * dp[i - j]) % mod; 
            }
            tmp = (tmp + 2) % mod;
            dp[i] = (int) tmp;
        }
        
        return dp[N];
    }
}
