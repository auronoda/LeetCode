class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] edge: tickets) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new PriorityQueue<>());
            }
            map.get(edge[0]).add(edge[1]);
        }
        dfs("JFK", map, res);
        return res;
    }
    
    private void dfs(String cur, Map<String, PriorityQueue<String>> map, List<String> res) {
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map.get(cur).poll(), map, res);
        }
        res.add(0, cur);
    }
}
