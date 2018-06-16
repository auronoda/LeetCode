class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int backS = 0, backT = 0;
        
        while (i >= 0 || j >= 0) {
            for (;i >= 0; --i) {
                if (S.charAt(i) == '#') {
                    backS++;
                }
                else if (backS > 0) {
                    backS--;
                }
                else {
                    break;
                }
            }
            for (;j >= 0; --j) {
                if (T.charAt(j) == '#') {
                    backT++;
                }
                else if (backT > 0) {
                    backT--;
                }
                else {
                    break;
                }
            }

            if (i < 0 && j < 0) {
                return true;
            }
            if (i < 0 || j < 0) {
                return false;
            }
            if (S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i--;j--;
        }
        return true;
    }   
    
}
