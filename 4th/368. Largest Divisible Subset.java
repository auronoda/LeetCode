class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] prev = new int[n];
        int[] l = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(l, 1);
        int max = 1;
        int idx = 0;
        
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && l[j] >= l[i]) {
                    l[i] = l[j] + 1;
                    prev[i] = j;
                }
            }
            if (l[i] > max) {
                max = l[i];
                idx = i;
            }
        }
        
        while (idx != -1) {
            res.add(nums[idx]);
            idx = prev[idx];
        }
        return res;
    }
}
