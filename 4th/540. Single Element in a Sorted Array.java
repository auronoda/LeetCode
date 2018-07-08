class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid == 0 && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            int neighbor = mid % 2 == 0? mid + 1: mid - 1;
            if (nums[mid] == nums[neighbor]) {
                start = Math.max(mid, neighbor) + 1;
            }
            else {
                end = Math.max(mid, neighbor) - 1;
            }
        }
        return -1;
    }
}
