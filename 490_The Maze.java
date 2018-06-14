class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        return dfs(maze, start[0], start[1], destination, visited);
    }
    
    private boolean dfs(int[][] maze, int i, int j, int[] dest, boolean[][] visited) {
        if (i == dest[0] && j == dest[1]) {
            return true;
        }
        int m = maze.length, n = maze[0].length;
        
        int tmp = i;
        while (tmp >= 0 && maze[tmp][j] == 0) {
            tmp--;
        }
        if (!visited[tmp + 1][j]) {
            visited[tmp + 1][j] = true;
            if (dfs(maze, tmp + 1, j, dest, visited)) {
                return true;
            }
        }
        
        tmp = i;
        while (tmp < m && maze[tmp][j] == 0) {
            tmp++;
        }
        if (!visited[tmp - 1][j]) {
            visited[tmp - 1][j] = true;
            if (dfs(maze, tmp - 1, j, dest, visited)) {
                return true;
            }
        }
        
        tmp = j;
        while (tmp < n && maze[i][tmp] == 0) {
            tmp++;
        }
        if (!visited[i][tmp - 1]) {
            visited[i][tmp - 1] = true;
            if (dfs(maze, i, tmp - 1, dest, visited)) {
                return true;
            }
        }
        
        tmp = j;
        while (tmp >= 0 && maze[i][tmp] == 0) {
            tmp--;
        }
        if (!visited[i][tmp + 1]) {
            visited[i][tmp + 1] = true;
            if (dfs(maze, i, tmp + 1, dest, visited)) {
                return true;
            }
        }
        
        return false;
    }
}
