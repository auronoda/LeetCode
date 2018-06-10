class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] edges = new int[n][n];
        for (int[] edge: flights) {
            edges[edge[0]][edge[1]] = edge[2];
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        Map<Integer, Integer> map = new HashMap<>();
        heap.add(new int[]{src, 0, 0});
        
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            if (cur[0] == dst) {
                return cur[2];
            }
            if (cur[1] > K || cur[2] > map.getOrDefault(cur[1] * 1000 + cur[0], Integer.MAX_VALUE)) {
                continue;
            }
            
            for (int i = 0; i < n; ++i) {
                if (edges[cur[0]][i] > 0 && cur[2] + edges[cur[0]][i] < map.getOrDefault((cur[1] + 1) * 1000 + i, Integer.MAX_VALUE)) {
                    map.put((cur[1] + 1) * 1000 + i, cur[2] + edges[cur[0]][i]);
                    heap.add(new int[]{i, cur[1] + 1, cur[2] + edges[cur[0]][i]});
                } 
            }
        }
        
        return -1;
    }
}
