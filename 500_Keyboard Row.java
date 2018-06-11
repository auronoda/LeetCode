class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        List<String> res = new ArrayList<>();
        for (String word: words) {
            if (word.length() <= 1) {
                res.add(word);
                continue;
            }
            char[] chars = word.toUpperCase().toCharArray();
            int row = 0;
            for (int i = 0; i < 3; ++i) {
                if (rows[i].indexOf(chars[0]) != -1) {
                    row = i;
                    break;
                }
            }
            
            int i = 1;
            for (; i < chars.length; ++i) {
                if (rows[row].indexOf(chars[i]) == -1) {
                    break;
                }
            }
            if (i == chars.length) {
                res.add(word);
            }
        }
        
        return res.toArray(new String[0]);
    }
}
