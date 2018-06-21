class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0; 
        while (i < A.length) {
            while (i < A.length - 1 && A[i] >= A[i + 1]) {
                ++i;
            }
            while (A[i] < A[i + 1]) {
                ++i;
            }
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
