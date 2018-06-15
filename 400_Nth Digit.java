class Solution {
    public int findNthDigit(int n) {
        int l = 1; 
        long count = 9;
        int start = 1;
        while (n > l * count){
            n -= l * count;
            l++;
            count *= 10;
            start *= 10;
        }
        int num = start + (n - 1) / l;
        String s = String.valueOf(num);
        return s.charAt((n - 1) % l) - '0';
    }
}
