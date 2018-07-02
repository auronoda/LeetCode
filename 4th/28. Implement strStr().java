class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int m = haystack.length(), n = needle.length();
        int[] kmp = helper(needle);
        int i = 0, j = 0;
        while (i < m) {
            if (j == n) {
                return i - n;
            }
            while (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = kmp[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            i++;
        }
        
        return j == n? m - n: -1;
    }
    
    private int[] helper(String s) {
        int n = s.length();
        int[] res = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = res[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            res[i] = j;
            i++;
        }
        return res;
    }
}
