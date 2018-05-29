class Solution {
    public boolean checkRecord(String s) {
        int ACount = 0, LCount = 0;
        for (int i = 0; i <s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'A') {
                ACount++;
                if (ACount == 2) {
                    return false;
                }
                LCount = 0;
            }
            else if (c == 'L') {
                LCount++;
                if (LCount == 3) {
                    return false;
                }
            }
            else {
                LCount = 0;
            }
        }
        return true;
    }
}
