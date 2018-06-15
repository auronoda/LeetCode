class Solution {
    public int maxRotateFunction(int[] A) {
        int tmp = 0; 
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            tmp += i * A[i];
            sum += A[i];
        }
        int res = tmp;
        for (int i = n - 1; i > 0; --i) {
            tmp = tmp + sum - n * A[i];
            res = Math.max(res, tmp);
        }
        
        return res;
    }
}
