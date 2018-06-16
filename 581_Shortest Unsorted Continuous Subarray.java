class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int start = 0, end = nums.length - 1;
        while (start < end && tmp[start] == nums[start]) {
            start++;
        }
        while (start < end && tmp[end] == nums[end]) {
            end--;
        }
        return start < end? end - start + 1: 0;
    }
}
