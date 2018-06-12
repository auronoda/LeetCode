class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        
        if (A.length() == 0) {
            return true;
        }
        
        String AA = A + A;
        int[] p = new int[B.length()];
        int i = 0; 
        for (int j = 1; j < B.length(); ++j) {
            while (i > 0 && B.charAt(i) != B.charAt(j)) {
                i = p[i - 1];
            }
            if (B.charAt(i) == B.charAt(j)) {
                i++;
            }
            p[j] = i;
        }
        
        i = 0;
        for (int j = 0; j < AA.length(); ++j) {
            while (i > 0 && B.charAt(i) != AA.charAt(j)) {
                i = p[i - 1];
            }
            if (B.charAt(i) == AA.charAt(j)) {
                i++;
            }
            if (i == B.length()) {
                return true;
            }
        }
        
        return false;
    }
}
