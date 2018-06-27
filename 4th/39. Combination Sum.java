class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; ++i) {
            dfs(res, list, candidates, target, i);
        }
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int cur) {
        list.add(candidates[cur]);
        target -= candidates[cur];
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        else if (target > 0) {
            for (int next = cur; next < candidates.length; ++next) {
                dfs(res, list, candidates, target, next);
            }
        }
        list.remove(list.size() - 1);
    }
}
