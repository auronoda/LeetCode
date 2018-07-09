class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; --i) {
            char c = chars[i];
            if (c == '-') {
                continue;
            }
            sb.append(c);
            count++;
            if (count == K) {
                count = 0;
                sb.append('-');
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
