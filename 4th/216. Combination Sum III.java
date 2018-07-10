class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, k, n, 1);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int n, int cur) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (n <= 0) {
            return;
        }
        
        for (int i = cur; i <= 9; ++i) {
            list.add(i);
            dfs(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
