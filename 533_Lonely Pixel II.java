class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        int m = picture.length, n = picture[0].length;
        int[] rows = new int[m], cols = new int[n];
        int res = 0;
        String[] strs = new String[m];
        Map<String, Set<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < m; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
                sb.append(picture[i][j]);
            }
            String s = sb.toString();
            if (!map.containsKey(s)) {
                map.put(s, new HashSet<>());
            }
            map.get(s).add(i);
            strs[i] = s;
        }
        
        search: for (int j = 0; j < n; ++j) {
            if (cols[j] != N) {
                continue;
            } 
            String s = null;
            for (int i = 0; i < m; ++i) {
                if (picture[i][j] == 'W') {
                    continue;
                }
                if (rows[i] != N || (s != null && !s.equals(strs[i]))) {
                    continue search;
                }
                if (s == null) {
                    s = strs[i];
                }
            }
            
            if (s != null) {
                res += map.get(s).size();
            }
        }
        
        return res;
    }
}
