class Solution {
    ArrayList<Integer>[] graph;
    int[] res;
    int[] quiet;
    
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        this.quiet = quiet;
        res = new int[n];
        Arrays.fill(res, -1);
        graph = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: richer) {
            graph[edge[1]].add(edge[0]);
        }
        
        for (int i = 0; i < n; ++i) {
            dfs(i);
        }
        
        return res;
    }
    
    private int dfs(int cur) {
        if (res[cur] == -1) {
            res[cur] = cur;
            for (int next: graph[cur]) {
                int tmp = dfs(next);
                if (quiet[res[cur]] > quiet[tmp]) {
                    res[cur] = tmp;
                }
            }
        }
        
        return res[cur];
    }
}
