class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0;
        int res = 0;
        for (int cur: nums) {
            if (cur == 1) {
                l++;
            }
            else {
                res = Math.max(res, l);
                l = 0;
            }
        }
        res = Math.max(res, l);
        return res;
    }
}
