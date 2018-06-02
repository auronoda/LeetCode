class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int[] left = new int[m], up = new int[n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                left[i] = Math.max(left[i], grid[i][j]);
                up[j] = Math.max(up[j], grid[i][j]);
            }
        }
        
        int res = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res += Math.min(left[i], up[j]) - grid[i][j];
            }
        }
        
        return res;
    }
}
