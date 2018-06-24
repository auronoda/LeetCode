class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int[] degrees = new int[n];
        for (int i = 0; i < n; ++i) {
            set.add(i);
        }
        for (int[] edge: edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());                
            }
            map.get(edge[0]).add(edge[1]);
            degrees[edge[0]]++;
            
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());                
            }
            map.get(edge[1]).add(edge[0]);
            degrees[edge[1]]++;
        }
        
        while (set.size() > 2) {
            Set<Integer> tmp = new HashSet<>();
            int[] newDegrees = degrees.clone();
            for (int cur: set) {
                if (degrees[cur] == 1) {
                    for (int neighbor: map.get(cur)) {
                        newDegrees[neighbor]--;
                    }
                }
                else {
                    tmp.add(cur);
                }
            }
            degrees = newDegrees;
            set = tmp;
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }
}
