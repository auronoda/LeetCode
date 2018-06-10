class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, 0, nums);
        return new ArrayList<>(res);        
    }
    
    private void dfs(Set<List<Integer>> res, List<Integer> list, int cur, int[] nums) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }        
        for (int j = cur; j < nums.length; ++j) {
            if (list.size() == 0 || nums[j] >= list.get(list.size() - 1)) {
                list.add(nums[j]);
                dfs(res, list, j + 1, nums);
                list.remove(list.size() - 1);
            }
        }        
    }
}
