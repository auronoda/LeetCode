class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] local = new int[m + 1][n + 1];
        int[][] global = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                global[i][j] = Math.max(global[i][j - 1], global[i - 1][j]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    local[i][j] = global[i - 1][j - 1] + 1;
                    global[i][j] = Math.max(global[i][j], local[i][j]);
                }
            }
        }
        return m + n - 2 * global[m][n];
    }
}
