class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = (n + "").toCharArray();
        for (int i = digits.length - 2; i >= 0; --i) {
            if (digits[i] < digits[i + 1]) {
                int j = digits.length - 1;
                while (digits[j] <= digits[i]) {
                    --j;
                }
                char tmp = digits[j];
                digits[j] = digits[i];
                digits[i] = tmp;
                Arrays.sort(digits, i + 1, digits.length);
                long res = Long.parseLong(new String(digits));
                return res <= Integer.MAX_VALUE? (int)res: -1;
            }
        }
        return -1;
    }    
}
