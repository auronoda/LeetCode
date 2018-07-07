class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
    
    private int helper(int[] nums, int start, int end) {
        if (nums == null || start > end) {
            return 0;
        }
        if (end == start) {
            return nums[start];
        }
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i <= end - start; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[end - start];
    }
}
