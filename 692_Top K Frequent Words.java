class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if (a.getValue() == b.getValue()) {
                    return b.getKey().compareTo(a.getKey());
                }
                return a.getValue() - b.getValue();
            }
        });
        List<String> res = new LinkedList<>();
        
        for (String cur: words) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        while(!heap.isEmpty()) {
            Map.Entry<String, Integer> entry = heap.poll();
            res.add(0, entry.getKey());
        }
        return res;
    }
}
