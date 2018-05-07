class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isVaild(i)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isVaild(int cur){
        boolean flag = false;
        int digit;
        while (cur > 0) {
            digit = cur % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                flag = true;
            }
            cur /= 10;
        }
        return flag;
    }
}
