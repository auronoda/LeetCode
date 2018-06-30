class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int l = 0;
        Integer prev = null;
        for (int cur: nums) {
            if (cur == 1) {
                l++;
            }
            else {
                res = Math.max(res, prev != null? l + prev + 1: l);
                prev = l;
                l = 0;
            }
        }
        res = Math.max(res, prev != null? l + prev + 1: l);
        return res;
    }
}
