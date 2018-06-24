class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            chars1[s1.charAt(i) - 'a']++;
            chars2[s2.charAt(i) - 'a']++;
        }
        if (equal(chars1, chars2)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); ++i) {
            chars2[s2.charAt(i) - 'a']++;
            chars2[s2.charAt(i - s1.length()) - 'a']--;
            if (equal(chars1, chars2)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean equal(int[] chars1, int[] chars2) {
        for (int i = 0; i < 26; ++i) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}
