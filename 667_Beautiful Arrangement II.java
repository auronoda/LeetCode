class Solution {
    public int[] constructArray(int n, int k) {
        int start = 1, end = n;
        int[] res = new int[n];
        int cur = 0;
        while (k >= 2) {
            res[cur++] = start++;
            res[cur++] = end--;
            k -= 2;
        }
        if (k == 1) {
            res[cur++] = start++;
            while (cur < n) {
                res[cur++] = start++;
            }
        }
        else {
            while (cur < n) {
                res[cur++] = end--;
            }
        }
        return res;
    }
}
