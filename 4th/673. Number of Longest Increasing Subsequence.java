class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        count[0] = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                    else if (length[j] == length[i] - 1) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int max = 0;
        int res = 0;
        for (int cur: length) {
            max = Math.max(max, cur);
        }
        for (int i = 0; i < n; ++i) {
            if (length[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}
