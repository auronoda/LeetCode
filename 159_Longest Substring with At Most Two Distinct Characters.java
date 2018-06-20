class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
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
            if (distinct <= 2) {
                res = Math.max(res, end - start);
            }
            else {
                while (distinct > 2) {
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
