class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] counts = new int[128];
        int distinct = 0;
        int start = 0, end = 0;
        int res = 0;
        while (end < s.length()) {
            char c = s.charAt(end++);
            counts[c]++;
            if (counts[c] == 1) {
                distinct++;
            }
            if (distinct <= k) {
                res = Math.max(res, end - start);
            }
            else {
                while (distinct > k) {
                    c = s.charAt(start++);
                    counts[c]--;
                    if (counts[c] == 0) {
                        distinct--;
                    }
                }
            }
        }
        return res;
    }
}
