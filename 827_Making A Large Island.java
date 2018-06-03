class Solution {
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] index = new int[m][n];
        Map<Integer, Integer> map = new HashMap<>();
        int curIndex = 1;
        int res = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                int tmp = 1;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                index[i][j] = curIndex;
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll(); 
                    for (int[] d: dir) {
                        int r = cur[0] + d[0];
                        int c = cur[1] + d[1];                    
                        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) {
                            continue;
                        }
                        queue.add(new int[]{r, c});
                        visited[r][c] = true;
                        index[r][c] = curIndex;
                        tmp++;
                    }
                }
                map.put(curIndex++, tmp);
                res = Math.max(res, tmp);
            }
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int tmp = 1;
                Set<Integer> set = new HashSet<>();
                for (int[] d: dir) {
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || set.contains(index[r][c])) {
                        continue;
                    }
                    tmp += map.get(index[r][c]);
                    set.add(index[r][c]);
                }
                res = Math.max(res, tmp);
            }
        }
        
        return res;
    }
}
