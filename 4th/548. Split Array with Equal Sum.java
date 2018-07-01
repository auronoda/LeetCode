class Solution {
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) {
            return false;
        }
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        
        for (int j = 3; j < n - 3; ++j) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; ++i) {
                if (sums[i - 1] == sums[j - 1] - sums[i]) {
                    set.add(sums[i - 1]);
                }
            }
            for (int k = j + 2; k < n - 1; ++k) {
                if (sums[n - 1] - sums[k] == sums[k - 1] - sums[j] && set.contains(sums[n - 1] - sums[k])) {
                    return true;
                }
            }
        }
        return false;
    }
}
