class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String cur: cpdomains) {
            String[] strs = cur.split(" ");
            int count = Integer.parseInt(strs[0]);
            strs = strs[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = strs.length - 1; i >= 0; --i) {
                if (sb.length() > 0) {
                    sb.insert(0, '.');
                }
                sb.insert(0, strs[i]);
                String tmp = sb.toString();
                map.put(tmp, map.getOrDefault(tmp, 0) + count);
            }
        }
        
        for (String s: map.keySet()) {
            res.add("" + map.get(s) + " " + s);
            
        }
        
        return res;
    }
    
}
