class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String cur: d) {
            if (isSubsequence(s, cur)) {
                res = findLonger(res, cur);
            }
        }
        return res;
    }
    
    private boolean isSubsequence(String s, String cur) {
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i++) == cur.charAt(j)) {
                j++;
                if (j == cur.length()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private String findLonger(String a, String b) {
        if (a.length() > b.length()) {
            return a;
        }
        if (a.length() < b.length()) {
            return b;
        }
        int i = 0; 
        while (i < a.length()) {
            if (a.charAt(i) < b.charAt(i)) {
                return a;
            }
            if (a.charAt(i) > b.charAt(i)) {
                return b;
            }
            ++i;
        }
        return a;
    }
}
