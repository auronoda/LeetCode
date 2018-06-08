class Solution {
    public int minimumLengthEncoding(String[] words) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });
        
        for (String cur: words) {
            if (sb.indexOf(cur) != -1 && sb.charAt(sb.indexOf(cur) + cur.length()) == '#') {
                continue;
            }
            sb.append(cur);
            sb.append('#');
        }
        
        return sb.length();
    }
}
