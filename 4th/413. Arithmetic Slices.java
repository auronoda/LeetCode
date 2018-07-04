class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int res = 0;
        int diff = A[1] - A[0];
        int l = 2;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == diff) {
                l++;
            }
            else {
                res += (l - 2) * (l - 1) / 2;
                diff = A[i] - A[i - 1];
                l = 2;
            }
        }
        res += (l - 2) * (l - 1) / 2;
        return res;
    }
}
