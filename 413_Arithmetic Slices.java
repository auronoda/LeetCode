class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int res = 0;
        int cur = 2;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
            }
            else {
                if (cur >= 3) {
                    res += (cur - 1) * (cur - 2) / 2;
                }
                cur = 2;
            }
        }
        if (cur >= 3) {
            res += (cur - 1) * (cur - 2) / 2;
        }
        return res;
    }
}
