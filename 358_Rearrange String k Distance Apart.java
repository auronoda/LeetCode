class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b){
                return b.getValue() - a.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        heap.addAll(map.entrySet());
        
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> cur = heap.poll();
            queue.add(cur);
            sb.append(cur.getKey());
            
            if (queue.size() < k) {
                continue;
            }
            
            cur = queue.poll();
            cur.setValue(cur.getValue() - 1);
            if (cur.getValue() > 0) {
                heap.add(cur);
            }
        }
        return sb.length() == s.length()? sb.toString(): "";       
    }
}
