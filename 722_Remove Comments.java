class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        
        for (String cur: source) {
            for (int i = 0; i < cur.length(); ++i) {
                if (i < cur.length() - 1 && !inBlock && (cur.charAt(i) == '/' && cur.charAt(i + 1) == '*')) {
                    inBlock = true; 
                    i++;
                }
                else if (i < cur.length() - 1 && inBlock && (cur.charAt(i) == '*' && cur.charAt(i + 1) == '/')) {
                    inBlock = false; 
                    i++;
                }
                else if (i < cur.length() - 1 && !inBlock && (cur.charAt(i) == '/' && cur.charAt(i + 1) == '/')) {
                    break;
                }
                else if (!inBlock) {
                    sb.append(cur.charAt(i));
                }
            }
            
            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        return res;
    }
}
