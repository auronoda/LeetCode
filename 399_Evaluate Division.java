class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; ++i) {
            String a = equations[i][0];
            String b = equations[i][1];
            double val = values[i];
            
            if (!map.containsKey(a)) {
                map.put(a, new HashMap<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashMap<>());
            }
            map.get(a).put(b, val);
            map.get(b).put(a, 1 / val);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            res[i] = dfs(queries[i][0], queries[i][1], 1, map, new HashSet<>());
        }
        
        return res;
    }
    
    private double dfs(String start, String target, double cur, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (!map.containsKey(start) || !map.containsKey(target) || visited.contains(start)) {
            return -1;
        }
        
        if (start.equals(target)) {
            return cur;
        }
        
        visited.add(start);
        for (String next: map.get(start).keySet()) {
            double tmp = dfs(next, target, cur * map.get(start).get(next), map, visited);
            if (tmp != -1) {
                return tmp;
            }
        }
        
        return -1;
    }
}
