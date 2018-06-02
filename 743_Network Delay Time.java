class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] edge: times) {
            if (!edges.containsKey(edge[0])) {
                edges.put(edge[0], new ArrayList<>());
            }
            edges.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        heap.add(new int[]{K, 0});
        
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            if (dist[cur[0] - 1] != Integer.MAX_VALUE) {
                continue;
            }
            dist[cur[0] - 1] = cur[1];
            if (!edges.containsKey(cur[0])) {
                continue;
            }
            for (int[] edge: edges.get(cur[0])) {
                if (dist[edge[0] - 1] == Integer.MAX_VALUE) {
                    heap.add(new int[]{edge[0], cur[1] + edge[1]});
                }
            }
        }
        
        int res = 0;
        for (int cur: dist) {
            if (cur == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, cur);
        }
        
        return res;
    }
}
