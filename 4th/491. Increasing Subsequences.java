class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            dfs(res, new ArrayList<>(), i, nums);
        }
        return new ArrayList<>(res);
    }
    
    private void dfs(Set<List<Integer>> res, List<Integer> list, int cur, int[] nums) {
        list.add(nums[cur]);
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        for (int next = cur + 1; next < nums.length; ++next) {
            if (nums[next] < nums[cur] || (next > cur + 1 && nums[next] == nums[next - 1])) {
                continue;
            }
            dfs(res, list, next, nums);
        }
        list.remove(list.size() - 1);
    }
}
