class Solution {
    public int findKthNumber(int m, int n, int k) {
        int start = 1, end = m * n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (count(mid, m, n) >= k) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    private int count(int mid, int m, int n) {
        int res = 0;
        for (int i = 1; i <= m; ++i) {
            res += Math.min(n, mid / i);
        }
        return res;
    }
}
