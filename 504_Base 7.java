class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean minus = false;
        if (num < 0) {
            num = -num;
            minus = true;
        }
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (minus) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
