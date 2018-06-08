class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        for (int i = 0; i < n; ++i) {
            if (sum[i + 1] * 2 == sum[n] + nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
