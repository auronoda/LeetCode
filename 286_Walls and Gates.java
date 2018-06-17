class Solution {
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        
        List<Integer> gates = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    gates.add(i * n + j);
                }
            }
        }
        
        for (int gate: gates) {
            bfs(rooms, gate);
        }
        
    }
    
    private void bfs(int[][] rooms, int gate) {
        int m = rooms.length, n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(gate);
        int dis = 1;
        while (!queue.isEmpty()) {
            int l = queue.size();
            for(int i = 0; i < l; ++i) {
                int cur = queue.poll();
                int r = cur / n;
                int c = cur % n;
                for (int[] d: dir) {
                    int nr = d[0] + r;
                    int nc = d[1] + c;
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc] || rooms[nr][nc] <= 0) {
                        continue;
                    }
                    rooms[nr][nc] = Math.min(rooms[nr][nc], dis);
                    visited[nr][nc] = true;
                    queue.add(nr * n + nc);
                }
            }            
            dis++;
        }
    }
}
