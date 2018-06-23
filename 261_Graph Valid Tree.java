class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] status = new int[n];
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<>());
        }
        for (int[]edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        if (!dfs(0, -1, map, status)) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if(status[i] != 2) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int cur, int prev, Map<Integer, List<Integer>> map, int[] status) {
        if (status[cur] == 2) {
            return true;
        }
        if (status[cur] == 1) {
            return false;
        }
        status[cur] = 1;
        for (int next: map.get(cur)) {
            if (next == prev) {
                continue;
            }
            if (!dfs(next, cur, map, status)) {
                return false;
            }
        }
        status[cur] = 2;
        return true;
    }
}
