class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            long tmp = 0;
            char c = s.charAt(i - 1);
            if (c != '*') {
                if (c != '0') {
                    tmp += (long)dp[i - 1];
                }
                if (i > 1) {
                    char prev = s.charAt(i - 2);
                    if ((prev == '1' || prev == '*')) {
                        tmp += (long)dp[i - 2];
                    }
                    if ((prev == '2' || prev == '*') && c < '7') {
                        tmp += (long)dp[i - 2];
                    }
                }
            }
            else {
                tmp += 9 * (long)dp[i - 1];
                if (i > 1) {
                    char prev = s.charAt(i - 2);
                    if (prev == '1') {
                        tmp += 9 * (long)dp[i - 2];
                    }
                    else if (prev == '2') {
                        tmp += 6 * (long)dp[i - 2];
                    }
                    else if (prev == '*') {
                        tmp += 15 * (long)dp[i - 2];
                    }
                }
            }
            dp[i] = (int)(tmp % 1000000007);
            
        }
        return dp[n];
    }
}
