class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i: map.keySet()) {
            int size = map.get(i);
            res += (size / (i + 1) + (size % (i + 1) == 0? 0: 1)) * (i + 1);
        }
        return res;
    }
}
