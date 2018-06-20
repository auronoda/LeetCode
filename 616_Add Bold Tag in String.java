class Solution {
    public String addBoldTag(String s, String[] dict) {
        int n = s.length();
        boolean[] isBold = new boolean[n];
        for (int i = 0; i < n; ++i) {
            for (String word: dict) {
                if (i + word.length() <= n && s.substring(i, i + word.length()).equals(word)) {
                    for (int j = i; j < i + word.length(); ++j) {
                        isBold[j] = true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if ((i == 0 || !isBold[i - 1]) && isBold[i]) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if ((i == n - 1 || !isBold[i + 1]) && isBold[i]) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
