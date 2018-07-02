class Solution {
    public String reorganizeString(String S) {
        int n = S.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        Character prev = null;
        for (int i = 0; i < n; ++i) {
            if (heap.isEmpty()) {
                return "";
            }
            char cur = heap.poll();
            map.put(cur, map.getOrDefault(cur, 0) - 1);
            sb.append(cur);
            if (prev != null && map.get(prev) > 0) {
                heap.add(prev);
            }
            prev = cur;
        }
        return sb.toString();
    }
}
