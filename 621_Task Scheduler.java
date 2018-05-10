class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });        
        int res = 0;
        
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.add(entry.getValue());
        }
        
        while (!pq.isEmpty()) {
            int i = 0; 
            List<Integer> tmp = new ArrayList<>();
            while (i <= n) {
                if (!pq.isEmpty()) {
                    int cur = pq.poll();
                    if (cur > 1) {
                        tmp.add(cur - 1);
                    }
                }
                res++;
                if (pq.isEmpty() && tmp.isEmpty()) {
                    break;
                }
                i++;
            }
            for (int cur: tmp) {
                pq.add(cur);
            }
        }
        return res;
    }
}
