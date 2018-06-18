class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < graph.length; ++i) {
            if (setA.contains(i) || setB.contains(i)) {
                continue;
            }
            if (!dfs(graph, i, setA, setB)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int cur, Set<Integer> setA, Set<Integer> setB) {
        if (setB.contains(cur)) {
            return false;
        }
        if (setA.contains(cur)) {
            return true;
        }
        
        setA.add(cur);
        for (int next: graph[cur]) {
            if (!dfs(graph, next, setB, setA)) {
                return false;
            }
        }
        
        return true;
    }
}
