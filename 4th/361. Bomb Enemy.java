class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] counts = new int[m][n];
        
        for (int i = 0; i < m; ++i) {
            int count = 0;
            int slow = 0, fast = 0;
            while (fast < n) {
                if (grid[i][fast] == 'E') {
                    count++;
                }
                else if (grid[i][fast] == 'W') {
                    while (slow <= fast) {
                        if (grid[i][slow] == '0') {
                            counts[i][slow] += count;
                        }
                        slow++;
                    }
                    count = 0;
                }
                fast++;
            }
            while (slow < n) {
                if (grid[i][slow] == '0') {
                    counts[i][slow] += count;
                }
                slow++;
            }
        }
        
        for (int j = 0; j < n; ++j) {
            int count = 0;
            int slow = 0, fast = 0;
            while (fast < m) {
                if (grid[fast][j] == 'E') {
                    count++;
                }
                else if (grid[fast][j] == 'W') {
                    while (slow <= fast) {
                        if (grid[slow][j] == '0') {
                            counts[slow][j] += count;
                        }
                        slow++;
                    }
                    count = 0;
                }
                fast++;
            }
            while (slow < m) {
                if (grid[slow][j] == '0') {
                    counts[slow][j] += count;
                }
                slow++;
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, counts[i][j]);
            }
        }
        return res;
    }
}
