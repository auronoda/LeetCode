class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < S.length()) {
            while (end < S.length() && S.charAt(end) == S.charAt(start)) {
                end++;
            }
            if (end - start >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end - 1);
                res.add(list);
            }
            start = end;
            end++;
        }
        return res;
    }
}
