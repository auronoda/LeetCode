class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] map = new double[K + 1][N][N];
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    map[i][j][k] = -1;
                }
            }
        }
        return dfs(N, K, r, c, map) / Math.pow(8, K);
    }
    
    private double dfs(int N, int K, int r, int c, double[][][] map){
        int[][] dir = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        if (map[K][r][c] != -1) {
            return map[K][r][c];
        }
        map[K][r][c] = 0;
        for (int[] d: dir) {
            map[K][r][c] = map[K][r][c] + dfs(N, K - 1, r + d[0], c + d[1], map);
        }
        return map[K][r][c];
    }
}
