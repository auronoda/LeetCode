class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0, prev = -1;
        int res = 0;
        for (int i: nums) {
            if (i == 1) {
                cur++;
            }
            else {
                res = Math.max(res, prev + 1 + cur);
                prev = cur;
                cur = 0;
            }
        }
        res = Math.max(res, prev + 1 + cur);
        return res;
    }
}
