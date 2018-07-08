class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int tail2 = 1, tail3 = 1, tail5 = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 0; i < n; ++i) {
            int min = Math.min(Math.min(tail2, tail3), tail5);
            nums[i] = min;
            if (min == tail2) {
                tail2 = nums[idx2++] * 2;
            }
            if (min == tail3) {
                tail3 = nums[idx3++] * 3;
            }
            if (min == tail5) {
                tail5 = nums[idx5++] * 5;
            }
        }
        return nums[n - 1];
    }
}
