class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        List<Integer> list = new ArrayList<>();
        list.add(-10000);
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        list.add(20000);
        int j = 0;
        for (int i = 0; i < S.length(); ++i) {
            res[i] = Math.min(Math.abs(i - list.get(j)), Math.abs(list.get(j + 1) - i));
            if (i == list.get(j + 1)) {
                ++j;
            }
        }
        
        return res;
    }
}
