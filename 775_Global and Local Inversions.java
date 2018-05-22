class Solution {
    public boolean isIdealPermutation(int[] A) {
        int max = -1;
        for (int i = 0; i < A.length - 2; ++i) {
            if (max < A[i]) {
                max = A[i];
            }
            if (max > A[i + 2]) {
                return false;
            }
        }
        return true;
    }
}
