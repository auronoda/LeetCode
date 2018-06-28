class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int[] res = new int[2];
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        if (nums[start] != target) {
            return new int[]{-1,-1};
        }
        res[0] = start;
        
        start = 0;
        end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target + 1) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        res[1] = nums[start] > target? start - 1: start;
        
        return res;
    }
}
