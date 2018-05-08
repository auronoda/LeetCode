class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        sums[0] = nums[0];
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        int[] left = new int[n];
        int max = 0;
        for (int i = 0; i < n - k + 1; ++i) {
            int cur = sums[i + k] - sums[i];
            if (cur > max) {
                max = cur;
                left[i] = i;
            }
            else {
                left[i] = left[i - 1];
            }
        }
        
        int[] right = new int[n];
        max = 0;
        
        for (int i = n - k; i >= 0; --i) {
            int cur = sums[i + k] - sums[i];
            if (cur >= max) {
                max = cur;
                right[i] = i;
            }
            else {
                right[i] = right[i + 1];
            }
        }
        
        int[] res = new int[3];
        max = 0;
        for (int i = k; i <= n - 2 * k; ++i) {
            int l = left[i - k];
            int r = right[i + k];
            int cur = sums[i + k] - sums[i] + sums[l + k] - sums[l] + sums[r + k] - sums[r];
            if (cur > max) {
                max = cur;
                res = new int[]{l, i, r};
            }
        }
        return res;
    }
}
