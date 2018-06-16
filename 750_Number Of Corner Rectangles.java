class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Set<Integer>[] rows = new Set[m];
        for (int i = 0; i < m; ++i) {
            rows[i] = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    rows[i].add(j);
                }
            }
        }
        
        int res = 0;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                int count = 0;
                for (int c: rows[j]) {
                    if (rows[i].contains(c)) {
                        count++;
                    }
                }
                res += count * (count - 1) / 2;
            }
        }
        
        return res;
    }
}
