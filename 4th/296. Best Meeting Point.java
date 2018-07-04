class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns= new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int row = 0, column = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                } 
            }
        }
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                if (grid[i][j] == 1) {
                    columns.add(j);
                } 
            }
        }
        if (rows.size() == 0) {
            return 0;
        }
        row = rows.get(rows.size() / 2);
        column = columns.get(columns.size() / 2);
        
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    res += Math.abs(i - row) + Math.abs(j - column);
                } 
            }
        }
        return res;
    }
}
