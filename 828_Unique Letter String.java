class Solution {
    public int uniqueLetterString(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        
        int mod = 1000000007;
        int n = S.length();
        int res = 0;
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; ++i) {
            char c = (char)('A' + i);
            List<Integer> list = new ArrayList<>();
            list.add(-1);
            map.put(c, list);
            for (int j = 0; j < n; ++j) {
                if (S.charAt(j) == c) {
                    list.add(j);
                }
            }
            list.add(n);
        }
        
        for (List<Integer> list: map.values()) {
            for (int i = 1; i < list.size() - 1; ++i) {
                res = (res + (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i))) % mod;
            }
        }
        
        return res;
    }
}
