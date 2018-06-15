class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        int start = 0, end = 0;
        int cur = nums[0];
        while (start < nums.length) {
            while (cur < k && end < nums.length) {
                end++;
                if (end < nums.length) {
                    cur *= nums[end];
                }                
            }
            res += (end - start);
            cur /= nums[start];
            start++;
            if (end < start) {
                end = start;
                cur = nums[start];
            }
        }
        
        return res;
    }
}
