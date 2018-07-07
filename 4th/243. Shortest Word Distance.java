class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                list1.add(i);
            }
            if (words[i].equals(word2)) {
                list2.add(i);
            }
        }
        int res = Integer.MAX_VALUE;
        int i = 0;
        for (int idx1: list1) {
            while (i < list2.size() && list2.get(i) < idx1) {
                res = Math.min(res, idx1 - list2.get(i));
                i++;
            }
            if (i < list2.size() && list2.get(i) == idx1) {
                i++;
            }
            if (i < list2.size()) {
                res = Math.min(res, list2.get(i) - idx1);
            }
        }
        return res;
    }
}
