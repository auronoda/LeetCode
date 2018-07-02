class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        long sum = 0;
        for (int cur: nums) {
            sum += cur;
        }
        if (sum % 4 != 0) {
            return false;
        }
        return dfs(nums, new long[4], 0, sum / 4);
    }
    
    private boolean dfs(int[] nums, long[] edges, int cur, long target) {
        if (cur == nums.length) {
            for (int i = 0; i < 4; ++i) {
                if (edges[i] != target) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < 4; ++i) {
            if (edges[i] + nums[cur] > target) {
                continue;
            }
            else {
                edges[i] += nums[cur];
                if (dfs(nums, edges, cur + 1, target)) {
                    return true;
                }
                edges[i] -= nums[cur];
            }
        }
        return false;
    }
}
