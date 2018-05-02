class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[m][n];
        int distance = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                int[] cur = queue.poll();
                for (int[] d: dir) {
                    int row = cur[0] + d[0];
                    int col = cur[1] + d[1];
                    if (row < 0 || row >= m || col < 0 || col >= n) {
                        continue;
                    }
                    if (visited[row][col] || matrix[row][col] != 1) {
                        continue;
                    }
                    matrix[row][col] = distance;
                    queue.add(new int[]{row,col});
                    visited[row][col] = true;
                }
            }
            distance++;
        }
        return matrix;
    }    
}
