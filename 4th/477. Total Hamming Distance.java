class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int res = 0;
        int tmp = 1;
        for (int i = 1; i < 32; ++i) {
            int zeros = 0, ones = 0;
            for (int cur: nums) {
                if ((cur & tmp) == 0) {
                    zeros++;
                }
                else {
                    ones++;
                }
            }
            tmp <<= 1;
            res += ones * zeros;
        }
        return res;
    }
}
