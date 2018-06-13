class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    String s = bfs(grid, i, j, visited);
                    if (set.add(s)) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
    
    private String bfs(int[][] grid, int i, int j, boolean[][] visited) {
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1},{0,-1}};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        StringBuilder sb = new StringBuilder();
        sb.append("0,0");
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d: dir) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                sb.append(';');
                sb.append(r - i);
                sb.append(',');
                sb.append(c - j);
                queue.add(new int[]{r,c});
            }
        }
        return sb.toString();
    }
}
