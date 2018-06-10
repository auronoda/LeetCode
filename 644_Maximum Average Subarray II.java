class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        
        double mid;
        while (max - min >= 1e-5) {
            mid = min + (max - min) / 2;
            System.out.println(mid);
            if (possible(nums, k, mid)) {
                min = mid;
            }
            else {
                max = mid;
            }
        }
        return min;
    }
    
    private boolean possible(int[] nums, int k, double mid) {
        int n = nums.length;
        double[] sums = new double[n + 1];
        double[] mins = new double[n + 1];
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1] - mid;
            mins[i] = Math.min(sums[i], mins[i - 1]);
        }
        for (int i = k; i <= n; ++i) {
            if (sums[i] - mins[i - k] >= 0) {
                return true;
            }
        }
        
        return false;
    }
}
