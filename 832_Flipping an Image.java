class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j <= (n - 1) / 2; ++j) {
                int tmp = A[i][j];
                A[i][j] = 1 - A[i][n - 1 - j];
                A[i][n - 1 - j] = 1 - tmp;
            }
        }
        
        return A;
    }
}
