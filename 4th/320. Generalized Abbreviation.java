class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        res.add(word);
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            dfs(res, chars, i);
        }
        return res;
    }
    
    private void dfs(List<String> res, char[] chars, int cur) {
        if (cur >= chars.length) {
            return;
        }
        char c = chars[cur];
        chars[cur] = '0';
        res.add(abb(chars));
        for (int next = cur + 1; next < chars.length; ++next) {
            dfs(res, chars, next);
        }
        chars[cur] = c;
    }
    
    private String abb(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        for (char c: chars) {
            if (c == '0') {
                l++;
            }
            else {
                if (l > 0) {
                    sb.append(l);
                    l = 0;
                }
                sb.append(c);
            }
        }
        if (l > 0) {
            sb.append(l);
        }
        return sb.toString();
    }
}
