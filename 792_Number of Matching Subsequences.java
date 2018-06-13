class Solution {
    
    public int numMatchingSubseq(String S, String[] words) {
        List<int[]>[] list = new ArrayList[26];
        for (int i = 0; i < 26; ++i) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < words.length; ++i) {
            char c = words[i].charAt(0);
            list[c - 'a'].add(new int[]{i, 0});
        }
        int res = 0;
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            List<int[]> tmp = list[c - 'a'];
            list[c - 'a'] = new ArrayList<>();
            for (int[] cur: tmp) {
                String word = words[cur[0]];
                if (cur[1] == word.length() - 1) {
                    res++;
                }
                else {
                    list[word.charAt(cur[1] + 1) - 'a'].add(new int[]{cur[0], cur[1] + 1});
                }
            }
        }
        return res;
    }
}
