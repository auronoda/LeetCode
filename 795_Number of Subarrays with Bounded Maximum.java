class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }
    private int count(int[] A, int max) {
        int res = 0; 
        int l = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] <= max) {
                res += ++l;
            }
            else {
                l = 0;
            }
        }
        return res;
    }
}
