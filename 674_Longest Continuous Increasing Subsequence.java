class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0; 
        int tmp = 0;
        int prev = Integer.MIN_VALUE;
        for (int cur: nums) {
            if (cur > prev) {
                tmp++;
                res = Math.max(res, tmp);
            }
            else {
                tmp = 1;
            }
            
            prev = cur;
        }
        
        return res;
    }
}
