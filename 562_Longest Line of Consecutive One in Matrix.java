class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        int m = M.length, n = M[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        int[] left = new int[m + n - 1];
        int[] right = new int[m + n - 1];
        int res = 0;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (M[i][j] == 1) {
                    rows[i] += 1;
                    cols[j] += 1;
                    left[i - j + n - 1] += 1;
                    right[i + j] += 1;
                    res = Math.max(res, rows[i]);
                    res = Math.max(res, cols[j]);
                    res = Math.max(res, left[i - j + n - 1]);
                    res = Math.max(res, right[i + j]);
                }
                else {
                    rows[i] = 0;
                    cols[j] = 0;
                    left[i - j + n - 1] = 0;
                    right[i + j] = 0;
                }
            }
        }
        
        return res;
    }
}
