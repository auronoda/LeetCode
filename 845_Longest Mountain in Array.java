class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int cur = 0;
        int res = 0;
        int peek = 0;
        int start = 0;
        while (cur < A.length - 1) {
            while (cur < A.length - 1 && A[cur] < A[cur + 1]) {
                cur++;
            }
            peek = cur;
            while (cur < A.length - 1 && A[cur] > A[cur + 1]) {
                cur++;
            }
            if (cur > peek && peek > start) {
                res = Math.max(res, cur - start + 1);                
            }
            while (cur < A.length - 1 && A[cur] >= A[cur + 1]) {
                cur++;
            }
            peek = cur;
            start = cur;
        }
        return res;
    }
}
