class Solution {
    private int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return 0;
        }
        int m = forest.size();
        int n = forest.get(0).size();
        int res = 0;
        int[] start = new int[]{0,0};
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (forest.get(i).get(j) > 1) {
                    heap.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        
        while (!heap.isEmpty()) {
            int[] target = heap.poll();
            int step = bfs(start, target, m, n, forest);
            if (step == -1) {
                return -1;
            }
            res += step;
            start[0] = target[0];
            start[1] = target[1];
        }
        return res;
    }
    
    private int bfs(int[] start, int[] target, int m, int n, List<List<Integer>> forest){
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                if (cur[0] == target[0] && cur[1] == target[1]) {
                    return res;
                }
                for (int[] d: dir) {
                    int r = cur[0] + d[0];
                    int c = cur[1] + d[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || forest.get(r).get(c) == 0) {
                        continue;
                    }
                    queue.add(new int[]{r,c});
                    visited[r][c] = true;
                }                
            }
            ++res;
        }
        return -1;
    }
}
