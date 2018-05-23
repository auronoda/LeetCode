class Solution {
    public String nearestPalindromic(String n) {
        long standard = getStandard(n);
        long cur = Long.parseLong(n);
        long higher;
        long lower;
        
        if (standard > cur) {
            higher = standard;
        }
        else {
            higher = getHigher(standard);
        }
        
        if (standard < cur) {
            lower = standard;
        }
        else {
            lower = getLower(standard);
        }
        
        return Math.abs(higher - cur) < Math.abs(lower - cur)? String.valueOf(higher): String.valueOf(lower);
    }
    
    private long getStandard(String n) {
        char[] chars = n.toCharArray();
        for (int i = 0; i < chars.length / 2; ++i) {
            chars[chars.length - 1 - i] = chars[i];
        }
        return Long.parseLong(String.valueOf(chars));
    }
    
    private long getHigher(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = (chars.length - 1) / 2; i >= 0; --i) {
            if (++chars[i] > '9') {
                chars[i] = '0';
            }
            else {
                break;
            }
        }
        if (chars[0] == '0') {
            return n + 2;
        }
        for (int i = 0; i < chars.length / 2; ++i) {
            chars[chars.length - 1 - i] = chars[i];
        }
        return Long.parseLong(String.valueOf(chars));
    }
    
    private long getLower(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = (chars.length - 1) / 2; i >= 0; --i) {
            if (--chars[i] < '0') {
                chars[i] = '9';
            }
            else {
                break;
            }
        }
        if (chars.length > 1 && chars[0] == '0') {
            return n - 2;
        }
        for (int i = 0; i < chars.length / 2; ++i) {
            chars[chars.length - 1 - i] = chars[i];
        }
        return Long.parseLong(String.valueOf(chars));
    }
}
