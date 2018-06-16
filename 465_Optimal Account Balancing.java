class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] cur: transactions) {
            map.put(cur[0], map.getOrDefault(cur[0], 0) - cur[2]);
            map.put(cur[1], map.getOrDefault(cur[1], 0) + cur[2]);
        }
        
        return dfs(new ArrayList<>(map.values()), 0);
    }
    
    private int dfs(List<Integer> list, int cur) {
        while (cur < list.size() && list.get(cur) == 0) {
            cur++;
        }
        if (cur == list.size()) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = cur + 1; i < list.size(); ++i) {
            if (list.get(cur) * list.get(i) < 0) {
                list.set(i, list.get(i) + list.get(cur));
                res = Math.min(res, dfs(list, cur + 1) + 1);
                list.set(i, list.get(i) - list.get(cur));
            }
        }
        return res;
    }
}
