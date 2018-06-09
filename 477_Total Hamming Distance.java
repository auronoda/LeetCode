class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; ++i) {
            int ones = 0, zeros = 0;
            for (int cur: nums) {
                
                if ((cur & mask) == 0) {
                    zeros++;
                }
                else {
                    ones++;
                }
            }
            res += ones * zeros;
            mask <<= 1;
        }
        
        return res;
    }
}
