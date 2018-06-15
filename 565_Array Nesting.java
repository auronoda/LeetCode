class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                res = Math.max(res, dfs(nums, i, visited));
            }
        }
        return res;
    }
    
    private int dfs(int[] nums, int i, boolean[] visited) {
        int res = 0;
        while (!visited[i]) {
            res++;
            visited[i] = true;
            i = nums[i];
        }
        
        return res;
    }
}
