class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(nums, target, map);
    }
    
    private int dfs(int[] nums, int target, Map<Integer, Integer> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        
        int res = 0;
        for (int i: nums) {
            res += dfs(nums, target - i, map);
        }
        
        map.put(target, res);
        return res;
    }
}
