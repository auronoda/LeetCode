class Solution {
    public String findContestMatch(int n) {
        if (n <= 1) {
            return "";
        }
        int cur = 2;
        StringBuilder sb = new StringBuilder("(1,2)");
        
        while (cur < n) {
            cur *= 2;
            StringBuilder tmp = new StringBuilder();
            
            for (int i = 0; i < sb.length();) {
                if (Character.isDigit(sb.charAt(i))) {
                    int num = sb.charAt(i) - '0';
                    ++i;
                    while (i < sb.length() && Character.isDigit(sb.charAt(i))) {
                        num = num * 10 + sb.charAt(i) - '0';
                        ++i;
                    }
                    
                    tmp.append("(" + num + ',' + (cur + 1 - num) + ')');
                }
                
                else {
                    tmp.append(sb.charAt(i));
                    ++i;
                }
            }
            
            sb = tmp;
        }
        
        return sb.toString();
    }
}
