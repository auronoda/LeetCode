class Solution {
    public int countBinarySubstrings(String s) {
        int[] counts = new int[2];
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(counts[0], counts[1]);
                counts[s.charAt(i) - '0'] = 0;
            }
            counts[s.charAt(i) - '0']++;
        }
        res += Math.min(counts[0], counts[1]);
        return res;
    }
}
