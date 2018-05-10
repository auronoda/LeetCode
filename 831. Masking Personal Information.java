class Solution {
    public String maskPII(String S) {
        StringBuilder sb = new StringBuilder();
        if (isEmail(S)) {
            S = S.toLowerCase();
            int at = S.indexOf("@");
            sb.append(S.charAt(0));
            sb.append("*****");
            sb.append(S.substring(at - 1, S.length()));
        }
        
        else {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < S.length(); ++i) {                
                if (Character.isDigit(S.charAt(i))) {
                    tmp.append(S.charAt(i));
                }                
            }
            if (tmp.length() > 10) {
                sb.append('+');
                for (int i = 1; i <= tmp.length() - 10; ++i) {
                    sb.append('*');
                }
                sb.append('-');
            }
            sb.append("***-***-");
            for (int i = tmp.length() - 4; i < tmp.length(); ++i) {
                sb.append(tmp.charAt(i));
            }
        }
        return sb.toString();
    }
    
    private boolean isEmail(String S){
        return S.indexOf("@") != -1;
    }
}
