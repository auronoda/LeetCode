class Solution {
    
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] map = new int[m][n];
        int res = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(matrix, map, i, j));
            }
        }
        return res;
    }
    
    private int dfs(int[][] matrix, int[][] map, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        if (map[i][j] != 0) {
            return map[i][j];
        }
        
        int res = 1;
        
        for (int[] d: dir) {
            int r = i + d[0];
            int c = j + d[1];
            if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[i][j]) {
                continue;
            }
            res = Math.max(res, dfs(matrix, map, r, c) + 1);
        }
        map[i][j] = res;
        return res;
    }
}
