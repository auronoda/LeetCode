class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            dfs(res, list, used, nums, i);
        }
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, boolean[] used, int[] nums, int cur) {
        list.add(nums[cur]);
        used[cur] = true;
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        else {
            for (int next = 0; next < nums.length; ++next) {
                if (used[next] || (next > 0 && nums[next] == nums[next - 1] && !used[next - 1])) {
                    continue;
                }
                dfs(res, list, used, nums, next);
            }
        }
        list.remove(list.size() - 1);
        used[cur] = false;
    }
}
