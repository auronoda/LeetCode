class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            int r = i;
            int c = 0;
            int val = matrix[r][c];
            while (r < m && c < n) {
                if (matrix[r][c] != val) {
                    return false;
                }
                r++;
                c++;
            }
        }
        for (int j = 1; j < n; ++j) {
            int r = 0;
            int c = j;
            int val = matrix[r][c];
            while (r < m && c < n) {
                if (matrix[r][c] != val) {
                    return false;
                }
                r++;
                c++;
            }
        }
        
        return true;
    }
}
