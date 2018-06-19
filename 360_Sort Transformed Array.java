class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = a >= 0? nums.length - 1: 0;
        while (left <= right) {
            int y1 = a * nums[left] * nums[left] + b * nums[left] + c;
            int y2 = a * nums[right] * nums[right] + b * nums[right] + c;
            if (a >= 0) {
                if (y1 < y2) {
                    res[i--] = y2;
                    right--;
                }
                else {
                    res[i--] = y1;
                    left++;
                }
            }
            
            else {
                if (y1 > y2) {
                    res[i++] = y2;
                    right--;
                }
                else {
                    res[i++] = y1;
                    left++;
                }
            }
            
        }
        return res;
    }
}
