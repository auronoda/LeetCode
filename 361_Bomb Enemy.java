class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        } 
        
        int m = grid.length;
        int n = grid[0].length;
        int row = 0;
        int[] col = new int[n];
        int res = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                
                if (i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = 0;
                    int k = i;
                    while (k < m && grid[k][j] != 'W') {
                        if (grid[k][j] == 'E') {
                            col[j]++;
                        }
                        k++;
                    }
                }
                
                if (j == 0 || grid[i][j - 1] == 'W') {
                    row = 0;
                    int k = j;
                    while (k < n && grid[i][k] != 'W') {
                        if (grid[i][k] == 'E') {
                            row++;
                        }
                        k++;
                    }
                }
                
                if (grid[i][j] == '0') {
                    res = Math.max(res, row + col[j]);
                }
            }
        }
        return res;
    }
}
