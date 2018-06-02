class Solution {
    public boolean PredictTheWinner(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        return helper(nums, 0, nums.length - 1, map) >= 0;
    }
    
    private int helper(int[] nums, int start, int end, Map<String, Integer> map) {
        String key = "" + start + "," + end;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        if (start > end) {
            return 0;
        }
        int res = Math.max(nums[start] - helper(nums, start + 1, end, map), nums[end] - helper(nums, start, end - 1, map));
        map.put(key, res);
        return res;
    }
}
