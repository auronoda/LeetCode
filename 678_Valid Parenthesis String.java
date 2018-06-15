class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                lo++;
            }
            else {
                lo--;
            }
            if (c == ')') {
                hi--;
            }
            else {
                hi++;
            }
            
            if (hi < 0) {
                return false;
            }
            lo = Math.max(lo, 0);
        }
        
        return lo == 0;
    }
}
