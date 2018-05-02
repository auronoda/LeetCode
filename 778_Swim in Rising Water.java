class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[n][n];
        int res = Math.max(grid[0][0], grid[n - 1][n - 1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        pq.add(new int[]{0,0,grid[0][0]});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                return res;
            }
            res = Math.max(res, cur[2]);
            for (int[] d: dir) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r < 0 || r >= n || c < 0 || c >= n ||visited[r][c]) {
                    continue;
                }
                pq.add(new int[]{r,c,grid[r][c]});
                visited[r][c] = true;
            }
        }
        return -1;
    }
}
