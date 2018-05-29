class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = new String(strs[0]);
        for (int i = 0; i < strs.length; ++i) {
            res = getCP(res, strs[i]);
        }
        return res;
    }
    
    private String getCP(String a, String b) {
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            i++;
        }
        return a.substring(0, i);
    }
}
