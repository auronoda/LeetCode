class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0, end = 0;
        int[] counts = new int[128];
        while (end < s.length()) {
            int c = (int)(s.charAt(end));
            counts[c]++;
            while (counts[c] > 1) {
                int tmp = (int)(s.charAt(start));
                counts[tmp]--;
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
