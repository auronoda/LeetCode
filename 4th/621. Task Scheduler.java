class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int max = 0;
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int count: map.values()) {
            max = Math.max(max, count);
        }
        int idle = (max - 1) * (n + 1);
        for (int count: map.values()) {
            res += count;
            if (idle > 0) {
                idle -= Math.min(count, max - 1);
            }
        }
        
        if (idle > 0) {
            res += idle;
        }
        return res;
    }
}
