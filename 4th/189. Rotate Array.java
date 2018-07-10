class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; ++i) {
            int tmp = nums[n - 1];
            for (int j = n - 1; j >= 1; --j) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }
}
