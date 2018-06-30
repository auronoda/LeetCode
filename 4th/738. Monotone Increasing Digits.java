class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] digits = ("" + N).toCharArray();
        int i = 0; 
        while (i < digits.length - 1 && digits[i] <= digits[i + 1]) {
            i++;
        }
        if (i == digits.length - 1) {
            return N;
        }
        while (i > 0 && digits[i] == digits[i - 1]) {
            i--;
        }
        digits[i]--;
        for (int j = i + 1; j < digits.length; ++j) {
            digits[j] = '9';
        }
        return Integer.valueOf(new String(digits));
    }
}
