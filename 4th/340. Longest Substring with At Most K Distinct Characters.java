class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        int start = 0, end = 0;
        int[] counts = new int[128];
        int count = 0;
        while (end < s.length()) {
            int c = (int)(s.charAt(end));
            counts[c]++;
            if (counts[c] == 1) {
                count++;
            }
            while (count > k) {
                int tmp = (int)(s.charAt(start));
                counts[tmp]--;
                if (counts[tmp] == 0) {
                    count--;
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
