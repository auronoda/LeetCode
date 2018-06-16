class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> set = new HashSet<>();
        int[][] dp = new int[N][N];
        for (int[] mine: mines) {
            set.add(mine[0] * N + mine[1]);
        }
        int res = 0;
        
        for (int i = 0; i < N; ++i) {
            int count = 0; 
            for (int j = 0; j < N; ++j) {
                count = set.contains(i * N + j)? 0: count + 1;
                dp[i][j] = count;
            }
            count = 0;
            for (int j = N - 1; j >= 0; --j) {
                count = set.contains(i * N + j)? 0: count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        
        for (int j = 0; j < N; ++j) {
            int count = 0; 
            for (int i = 0; i < N; ++i) {
                count = set.contains(i * N + j)? 0: count + 1;
                dp[i][j] = dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            for (int i = N - 1; i >= 0; --i) {
                count = set.contains(i * N + j)? 0: count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
                res = Math.max(dp[i][j], res);
            }
        }
        
        return res;
    }
}
