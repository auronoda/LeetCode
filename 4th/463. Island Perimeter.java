class Solution {
    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int i = 0, j = 0;
        loop: for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    break loop;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        queue.add(i * n + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int r = cur / n, c = cur % n;
            for (int[] d: dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 0) {
                    res++;
                }
                else {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(nr * n + nc);
                    }
                }
            }
        }
        return res;
    }
}
