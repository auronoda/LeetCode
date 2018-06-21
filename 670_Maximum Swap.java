class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < digits.length; ++i) {
            last[digits[i] - '0'] = i;
        }
        for (int i = 0; i < digits.length; ++i) {
            for (int n = 9; n > digits[i] - '0'; --n) {
                if (last[n] > i) {

                    digits[last[n]] = digits[i];
                    digits[i] = (char)('0' + n);
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
