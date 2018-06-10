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
        
        for (int j = 3; j < n - 2; ++j) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; ++i) {
                if (sums[j - 1] - sums[i] == sums[i - 1]) {
                    set.add(sums[i - 1]);
                }
            }
            for (int k = j + 2; k < n; ++k) {
                if (set.contains(sums[k - 1] - sums[j]) && sums[n - 1] - sums[k] == sums[k - 1] - sums[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
