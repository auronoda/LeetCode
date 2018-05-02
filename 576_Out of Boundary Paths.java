class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] map = new int[N + 1][m][n];
        for (int ii = 1; ii <= N; ii++) {
            for (int jj = 0; jj < m; jj++) {
                for (int kk = 0; kk < n; kk++) {
                    map[ii][jj][kk] = -1;
                }
            }
        }
        return dfs(m, n, N, i, j, map);
    }
    
    private int dfs(int m, int n, int N, int i, int j, int[][][] map){
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int mod = 1000000007;
        
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        
        int[] key = new int[]{N, i, j};
        if (map[N][i][j] != -1) {
            return map[N][i][j];
        }
        
        map[N][i][j] = 0;
        for (int[] d: dir) {
            map[N][i][j] = (map[N][i][j] + dfs(m, n, N - 1, i + d[0], j + d[1], map)) % mod;
        }
        return map[N][i][j];
    }
}
