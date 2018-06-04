class Solution {
    public int racecar(int target) {
        int tmp = target;
        int count = 1; 
        while (tmp > 1) {
            tmp /= 2;
            count++;
        }
        int range = 1;
        for (int i = 1; i <= count; ++i) {
            range *= 2;
        }
        int[] dp = new int[range];
        Arrays.fill(dp, Integer.MAX_VALUE);
        tmp = 1;
        count = 0;
        while (tmp <= range) {
            dp[tmp - 1] = count;
            count++;
            tmp *= 2;
        }
        
        for (int i = 1; i <= target; ++i) {
            if (dp[i] != Integer.MAX_VALUE) {
                continue;
            }
            int k = 32 - Integer.numberOfLeadingZeros(i);
            for (int j = 0; j < k - 1; ++j) {
                dp[i] = Math.min(dp[i], dp[i - (1 << (k - 1)) + (1 << j)] + 2 + k - 1 + j);
            }
            
            dp[i] = Math.min(dp[i], k + 1 + dp[(1 << k) - 1 - i]);
        }
        return dp[target];
    }
}
