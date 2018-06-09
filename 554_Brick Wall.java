class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> cur: wall) {
            int sum = 0;
            for (int i = 0; i < cur.size() - 1; ++i) {
                sum += cur.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int max = 0;
        for (int i: map.keySet()) {
            max = Math.max(max, map.get(i));
        }
        
        return wall.size() - max;
    }
}
