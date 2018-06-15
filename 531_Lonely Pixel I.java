class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        int m = picture.length, n = picture[0].length;
        int[] rows = new int[m], cols = new int[n];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        
        for (int i = 0; i < m; ++i) {
            if (rows[i] != 1) {
                continue;
            }
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B') {
                    if (cols[j] == 1) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
}
