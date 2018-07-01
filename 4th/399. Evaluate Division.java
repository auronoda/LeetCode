class Solution {
    private class Edge {
        String vertex;
        double val;
        Edge(String vertex, double val) {
            this.vertex = vertex;
            this.val = val;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < values.length; ++i) {
            String v1 = equations[i][0], v2 = equations[i][1];
            if (!map.containsKey(v1)) {
                map.put(v1, new ArrayList<>());
            }
            map.get(v1).add(new Edge(v2, values[i]));
            if (!map.containsKey(v2)) {
                map.put(v2, new ArrayList<>());
            }
            map.get(v2).add(new Edge(v1, 1 / values[i]));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            res[i] = dfs(queries[i][0], queries[i][1], new HashSet<>(), map, 1);
        }
        return res;
    }
    
    private double dfs(String cur, String target, Set<String> visited, Map<String, List<Edge>> map, double val) {
        if (!map.containsKey(cur)) {
            return -1;
        }
        if (cur.equals(target)) {
            return val;
        }
        visited.add(cur);
        
        for (Edge next: map.get(cur)) {
            if (visited.contains(next.vertex)) {
                continue;
            }
            double tmp = dfs(next.vertex, target, visited, map, val * next.val);
            if (tmp != -1) {
                return tmp;
            }
        }
        visited.remove(cur);
        return -1;
    }
}
