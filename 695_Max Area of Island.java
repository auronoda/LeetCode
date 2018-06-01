class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int res = 0; 
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res = Math.max(res, bfs(grid, visited, i, j));
                }
            }
        }
        return res;
    }
    
    private int bfs(int[][] grid, boolean[][] visited, int i, int j) {
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        int res = 1;
        visited[i][j] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d: dir) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                res++;
                queue.add(new int[]{r, c});
            }
        }
        return res;
    }
}
