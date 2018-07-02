class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int tmp = 1;
        for (int i = 1; i <= 31; ++i) {
            if ((x & tmp) != (y & tmp)) {
                res++;
            }
            tmp <<= 1;
        }
        return res;
    }
}
