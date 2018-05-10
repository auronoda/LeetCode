class Solution {
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        int plus = 0;
        int n = 1;
        while (plus < N) {
            if ((N - plus) % n == 0) {
                res++;
            }
            plus += n;
            n++;
        }
        return res;
    }
}
