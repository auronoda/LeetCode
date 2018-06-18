class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i < S.length() - 1; ++i) {
            List<String> first = helper(S, 1, i);
            List<String> second = helper(S, i, S.length() - 1);
            if (first.size() > 0 && second.size() > 0) {
                for (String s: first) {
                    for (String t: second) {
                        res.add("(" + s + ", " + t + ')');
                    }
                }
            }
        }
        return res;
    }
    
    private List<String> helper(String S, int start, int end) {
        List<String> res = new ArrayList<>();
        if (end - start == 1) {
            res.add(S.substring(start, end));
            return res;
        }
        if (S.charAt(start) == '0' && S.charAt(end - 1) == '0') {
            return res;
        }
        if (S.charAt(start) == '0') {
            StringBuilder sb = new StringBuilder(S.substring(start, end));
            res.add(sb.insert(1, '.').toString());
            return res;
        }
        if (S.charAt(end - 1) == '0') {
            res.add(S.substring(start, end));
            return res;
        }
        res.add(S.substring(start, end));
        for (int i = 1; i < end - start; ++i) {
            StringBuilder sb = new StringBuilder(S.substring(start, end));
            res.add(sb.insert(i, '.').toString());
        }
        return res;
    }
}
