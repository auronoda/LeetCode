class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) {
            return 0;
        }
        int[] counts = new int[26];
        counts[p.charAt(0) - 'a'] = 1;
        int l = 1;
        for (int i = 1; i < p.length(); ++i) {
            if ((p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                l++;
                counts[p.charAt(i) - 'a'] = Math.max(l, counts[p.charAt(i) - 'a']);
            }
            else {
                l = 1;
            }
            counts[p.charAt(i) - 'a'] = Math.max(l, counts[p.charAt(i) - 'a']);
        }
        
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            res += counts[i];
        }
        return res;
    }
}
