class Solution {
    public String crackSafe(int n, int k) {
        int total = (int)Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; ++i) {
            sb.append(0);
        }
        set.add(sb.toString());
        dfs(sb, total, set, n, k);
        return sb.toString();
    }
    
    private boolean dfs(StringBuilder sb, int total, Set<String> set, int n, int k) {
        if (set.size() == total) {
            return true;
        }
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; ++i) {
            String cur = prev + i;
            if (!set.contains(cur)) {
                set.add(cur);
                sb.append(i);
                if (dfs(sb, total, set, n, k)) {
                    return true;
                }
                sb.delete(sb.length() - 1, sb.length());
                set.remove(cur);
            }
        }
        return false;
    }
}
