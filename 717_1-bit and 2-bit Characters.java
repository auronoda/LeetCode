class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        if (bits.length == 2) {
            return bits[0] == 0;
        }
        int n = bits.length;
        if (bits[n - 2] == 0) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = bits[0] == 0;
        for (int i = 2; i < n - 1; ++i) {
            if (dp[i - 1] && (bits[i - 1] == 0)) {
                dp[i] = true;
            }
            if (dp[i - 2] && bits[i - 2] == 1) {
                dp[i] = true;
            }
        }
        return !dp[n - 2];
    }
}
