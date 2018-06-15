class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }
        
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                if(grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }
        
        int res = 0;
        int start = 0, end = rows.size() - 1;
        while (start < end) {
            res += (rows.get(end--) - rows.get(start++));
        }
        start = 0;
        end = cols.size() - 1;
        while (start < end) {
            res += (cols.get(end--) - cols.get(start++));
        }
        
        return res;
    }
}
