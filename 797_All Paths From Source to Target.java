class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        return dfs(graph, 0, map);
    }
    
    private List<List<Integer>> dfs(int[][] graph, int cur, Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        List<List<Integer>> res = new ArrayList<>();
        if (cur == graph.length - 1) {
            List<Integer> list = new ArrayList<>();
            list.add(cur);
            res.add(list);
            return res;
        }
        
        for (int next: graph[cur]) {
            List<List<Integer>> tails = dfs(graph, next, map);
            for (List<Integer> tail: tails) {
                List<Integer> list = new ArrayList<>();
                list.add(cur);
                list.addAll(tail);
                res.add(list);
            }
        }
        map.put(cur, res);
        return res;        
    }
}
