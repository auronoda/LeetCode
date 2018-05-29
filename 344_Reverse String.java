class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() -1;
        while (i >=  0) {
            sb.append(s.charAt(i--));
        }
        return sb.toString();
    }
}
