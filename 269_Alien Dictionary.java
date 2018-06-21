class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Set<Character> chars = new HashSet<>();
        Set<Character> nodes = new HashSet<>();
        for (String s: words) {
            for (int i = 0; i < s.length(); ++i) {
                chars.add(s.charAt(i));
            }
        }
        
        for (int i = 0; i < words.length; ++i) {
            String s = words[i];
            for (int j = i + 1; j < words.length; ++j) {
                String t = words[j];
                for (int k = 0; k < Math.min(s.length(), t.length()); ++k) {
                    if (s.charAt(k) != t.charAt(k)) {
                        if (!map.containsKey(s.charAt(k))) {
                            map.put(s.charAt(k), new HashSet<>());
                        }
                        map.get(s.charAt(k)).add(t.charAt(k));
                        nodes.add(s.charAt(k));
                        nodes.add(t.charAt(k));
                        break;
                    }
                }
            }
        }
        
        int[] status = new int[26];
        StringBuilder res = new StringBuilder();
        for (char cur: map.keySet()) {
            StringBuilder tmp = new StringBuilder();
            if (!dfs(cur, map, status, tmp)) {
                return "";
            }
            res.insert(0, tmp);
        }
        for (char cur: chars) {
            if (!nodes.contains(cur)) {
                res.append(cur);
            }
        }
        
        return res.toString();
    }
    
    private boolean dfs(char cur, Map<Character, Set<Character>> map, int[] status, StringBuilder tmp) {
        if (status[cur - 'a'] == 1) {
            return false;
        } 
        if (status[cur - 'a'] == 2) {
            return true;
        } 
        status[cur - 'a'] = 1;
        if (map.containsKey(cur)) {
            for (char next: map.get(cur)) {
                if (!dfs(next, map, status, tmp)) {
                    return false;
                }
            }
        } 
        tmp.insert(0, cur);
        status[cur - 'a'] = 2;
        return true;
    }
}
