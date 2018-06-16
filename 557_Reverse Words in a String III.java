class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
         for (int i = strs.length - 1; i >= 0; --i) {
             sb.append(strs[i]).append(' ');
         }
        sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}
