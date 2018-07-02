class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        List<Integer> counts = new ArrayList<>();
        int l = 1;
        int res = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                l++;
            }
            else {
                counts.add(l);
                l = 1;
            }
        }
        counts.add(l);
        for (int i = 0; i < counts.size() - 1; ++i) {
            res += Math.min(counts.get(i), counts.get(i + 1));
        }
        return res;
    }
}
