class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.add(entry.getValue());
        }
        
        int qSize = 0;
        
        while (!pq.isEmpty() || qSize > 0) {
            int next = -1;
            int cur;
            if (!pq.isEmpty()) {
                cur = pq.poll();
                if (cur > 1) {
                    next = cur - 1;
                    qSize++;
                }
            }
            queue.add(next);
            if (queue.size() > n) {
                cur = queue.poll();
                if (cur > 0) {
                    qSize--;
                    pq.add(cur);
                }
            }
            res++;
        }
        return res;
    }
}
