class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 10;
        int cur = 9;
        for (int i = 2; i <= Math.min(n, 10); ++i) {
            cur *= (11 - i);
            res += cur;
        }
        return res;
    }    
}
