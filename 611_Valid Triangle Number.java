class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int max = i + 2;
            for (int j = i + 1; j < nums.length - 1; ++j) {                
                while (max < nums.length && (max <= j || nums[max] < nums[j] + nums[i])) {
                    max++;
                }
                
                res += max - j - 1;
            }
        }
        return res;
    }
}
