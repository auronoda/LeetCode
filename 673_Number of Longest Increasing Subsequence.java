class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[]length = new int[n];
        int[]count = new int[n];
        Arrays.fill(count, 1);
        int max = 0;
        
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                        max = Math.max(max, length[i]);
                    }
                    else if (length[j] == length[i] - 1) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (length[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}
