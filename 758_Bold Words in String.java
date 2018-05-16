class Solution {
    public String boldWords(String[] words, String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        
        boolean[] bold = new boolean[S.length()];
        
        for (String word: words) {
            for (int i = 0; i <= S.length() - word.length(); ++i) {
                if (word.equals(S.substring(i, i + word.length()))) {
                    for (int j = i; j < i + word.length(); ++j) {
                        bold[j] = true;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); ++i) {
            if (bold[i] && (i == 0 || !bold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if (bold[i] && (i == S.length() - 1 || !bold[i + 1])) {
                sb.append("</b>");
            }
        }
        
        return sb.toString(); 
    }
}
