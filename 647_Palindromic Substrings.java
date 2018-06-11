class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1;
        for (int i = 1; i < s.length(); ++i) {
            for (int start = i, end = i; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                res++;
            }
            for (int start = i - 1, end = i; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                res++;
            }
        }
        return res;
    }
}
