class Solution {
    public int pathSum(int[] nums) {
        int[][] sums = new int[5][9];
        boolean[][] notLeaf = new boolean[5][9];
        int res = 0;
        for (int cur: nums) {
            int d = cur / 100;
            int idx = cur / 10 % 10;
            int val = cur % 10;
            if (d == 1) {
                sums[d][idx] = val;
            }
            else {
                sums[d][idx] = val + sums[d - 1][(idx + 1) / 2];
                notLeaf[d - 1][(idx + 1) / 2] = true;
            }
            
        }
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= 8; ++j) {
                if (!notLeaf[i][j]) {
                    res += sums[i][j];
                }
            }
        }
        return res;
    }
}
