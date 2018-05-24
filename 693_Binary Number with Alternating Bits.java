class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n <= 1) {
            return true;
        }
        int last = (n & 1);
        n >>>= 1;
        while (n > 0) {
            if ((n & 1) == last) {
                return false;
            }
            last = (n & 1);
            n >>>= 1;
        }
        return true;
    }
}
