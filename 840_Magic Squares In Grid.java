class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int r = 0; r < m - 2; ++r) {
            search: for (int c = 0; c < n - 2; ++c) {
                Set<Integer> set = new HashSet<>();
                int[] rowSums = new int[3];
                int[] colSums = new int[3];
                int[] diags = new int[2];
                for (int i = 0; i < 3; ++i) {                    
                    for (int j = 0; j < 3; ++j) {
                        int cur = grid[r + i][c + j];
                        if (cur < 1 || cur > 9 || !set.add(cur)) {
                            continue search;
                        }
                        rowSums[i] += cur;
                        colSums[j] += cur;
                        if (i == j) {
                            diags[0] += cur;
                        }
                        if (i + j == 2) {
                            diags[1] += cur;
                        }
                    }
                }
                for (int i = 0; i < 3; ++i) {
                    if (rowSums[i] != 15 || colSums[i] != 15 || (i < 2 && diags[i] != 15)) {
                        continue search;
                    }
                }
                res++;
            }
        }
        
        return res;
    }
}
