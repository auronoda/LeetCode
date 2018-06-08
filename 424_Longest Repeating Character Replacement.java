class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0; 
        int start = 0, end = 0;
        int[] count = new int[26];
        int max = 0;
        while (end < s.length()) {
            count[s.charAt(end) - 'A']++;
            max = Math.max(max, count[s.charAt(end) - 'A']);
            while (end - start + 1 - max > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
