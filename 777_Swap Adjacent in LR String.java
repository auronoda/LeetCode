class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end .length()) {
            return false;
        }
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }            
        int l = 0, r = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'L') {
                l++;
            }
            else if (start.charAt(i) == 'R') {
                r++;
            }
            
            if (end.charAt(i) == 'L') {
                l--;
            }
            else if (end.charAt(i) == 'R') {
                r--;
            }
            
            if (l > 0 || r < 0) {
                return false;
            }
        }
        
        return l == 0 && r == 0;
    }
}
