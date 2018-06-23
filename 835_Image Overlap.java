class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int[][] counts = new int[2 * n - 1][2 * n - 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] == 1) {
                    for (int r = 0; r < n; ++r) {
                        for (int c = 0; c < n; ++c) {
                            if (B[r][c] == 1) {
                                counts[i - r + n - 1][j - c + n - 1]++;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int[] row: counts) {
            for (int cur: row) {
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
