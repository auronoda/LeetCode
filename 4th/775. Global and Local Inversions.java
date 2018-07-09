class Solution {
    public boolean isIdealPermutation(int[] A) {
        int max = -1, second = -1;
        for (int i = 0; i < A.length; ++i) {
            int cur = A[i];
            if (cur < second) {
                return false;
            }
            if (cur < max) {
                if (A[i - 1] != max) {
                    return false;
                }
                second = cur;
            }
            else {
                second = max;
                max = cur;
            }            
        }
        return true;
    }
}
