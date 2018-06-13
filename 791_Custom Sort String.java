class Solution {
    public String customSortString(String S, String T) {
        boolean[] appearedS = new boolean[26];
        int[] appearedT = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            appearedS[c - 'a'] = true;
        }
        for (char c: T.toCharArray()) {
            if (appearedS[c - 'a']) {
                appearedT[c - 'a']++;
            }
            else {
                sb.append(c);
            }
        }
        for (char c: S.toCharArray()) {
            while (appearedT[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
