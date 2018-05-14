class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int cur: nums) {
            if (cur > second) {
                return true;
            }
            if (cur > first) {
                second = cur;
            }
            else {
                first = cur;
            }
        }
        
        return false;
    }
}
