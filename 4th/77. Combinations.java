class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            dfs(res, list, i, n, k);
        }
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, int cur, int n, int k) {
        list.add(cur);
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        else {
            for (int next = cur + 1; next <= n; ++next) {
                dfs(res, list, next, n, k);
            }
        }
        list.remove(list.size() - 1);
    }
}
