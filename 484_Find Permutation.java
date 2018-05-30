class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        int i = 0;
        int j = 0;
        while (i <= s.length()) {
            if (i == s.length() || s.charAt(i) == 'I') {
                int diff = 0;
                while (j <= i) {
                    res[j++] = i + 1 + diff--;
                }
            }
            i++;
        }
        return res;
    }
}
