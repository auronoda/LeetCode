class Solution {
    public boolean checkPossibility(int[] nums) {
        int prev = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        boolean changed = false;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < prev) {
                if (changed) {
                    return false;
                }
                changed = true;
                if (nums[i] < second) {
                    second = prev;
                }
                else {
                    prev = nums[i];
                }
            }
            else {
                second = prev;
                prev = nums[i];
            }
        }
        return true;
    }
}
