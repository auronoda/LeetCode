class Solution {
    public int pathSum(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        
        for (int cur: nums) {
            int depth = cur / 100;
            int index = (cur / 10) % 10;
            int val = cur % 10;
            int sum = map.get((depth - 1) * 10 + (index + 1) / 2) + val;
            map.put(depth * 10 + index, sum);
        }
        
        for (int cur: nums) {
            int depth = cur / 100;
            int index = (cur / 10) % 10;
            if (!map.containsKey((depth + 1) * 10 + index * 2) && !map.containsKey((depth + 1) * 10 + index * 2 - 1)) {
                res += map.get(depth * 10 + index);
            }
        }
        
        
        return res;
    }
}
