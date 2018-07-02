class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (String s: allowed) {
            String bt = s.substring(0, 2);
            if (!map.containsKey(bt)) {
                map.put(bt, new HashSet<>());
            }
            map.get(bt).add(s.charAt(2));
        }
        return dfs(bottom, map, new StringBuilder(), 0);
    }
    
    private boolean dfs(String bottom, Map<String, Set<Character>> map, StringBuilder sb, int cur) {
        if (bottom.length() == 1) {
            return true;
        }
        if (cur == bottom.length() - 1) {
            return dfs(sb.toString(), map, new StringBuilder(), 0);
        }
        String bt = bottom.substring(cur, cur + 2);
        if (!map.containsKey(bt)) {
            return false;
        }
        for (char c: map.get(bt)) {
            sb.append(c);
            if (dfs(bottom, map, sb, cur + 1)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }
}
