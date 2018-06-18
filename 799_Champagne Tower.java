class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[102][102];
        glasses[0][0] = poured;
        for (int i = 0; i <= query_row; ++i) {
            for (int j = 0; j <= i; ++j) {
                double fall = (glasses[i][j] - 1) / 2;
                if (fall > 0) {
                    glasses[i][j] = 1;
                    glasses[i + 1][j] += fall;
                    glasses[i + 1][j + 1] += fall;
                }
            }
        }
        return glasses[query_row][query_glass];
    }
}
