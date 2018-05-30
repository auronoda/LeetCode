class Solution {
    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        int[][] avil = new int[m][n];
        int numHouses = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    
                    numHouses++;
                    boolean[][] visited = new boolean[m][n];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    int dis = 0;
                    
                    while (!queue.isEmpty()) {
                        int l = queue.size();
                        for (int k = 0; k < l; ++k) {
                            int[] cur = queue.poll();
                            res[cur[0]][cur[1]] += dis;
                            avil[cur[0]][cur[1]] ++;
                            for (int[] d: dir) {
                                int r = cur[0] + d[0];
                                int c = cur[1] + d[1];
                                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 0 || visited[r][c]) {
                                    continue;
                                }
                                visited[r][c] = true;
                                queue.add(new int[]{r,c});
                            }
                        }
                        dis++;
                    }                    
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 && avil[i][j] == numHouses) {
                    min = Math.min(min, res[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE? -1: min;
    }
}
