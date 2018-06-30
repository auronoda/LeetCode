class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < dp.length; ++i) {
            if (dp[i]) {
                for (int next = i + 1; next <= Math.min(n - 1, i + nums[i]); ++next) {
                    if (next == n - 1) {
                        return true;
                    }
                    dp[next] = true;
                }
            }
        }
        return dp[n - 1];
    }
}
