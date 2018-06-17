class Solution {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            StringBuilder tmp = new StringBuilder(word);
            char c = word.charAt(0);
            if (!set.contains(c)) {
                tmp.deleteCharAt(0);
                tmp.append(c);
            }
            tmp.append("ma");
            for (int j = 0; j <= i; ++j) {
                tmp.append('a');
            }
            sb.append(tmp).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
