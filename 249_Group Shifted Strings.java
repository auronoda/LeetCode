class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String cur: strings) {
            String code = encode(cur);
            if (!map.containsKey(code)) {
                map.put(code, new LinkedList<>());
            }
            map.get(code).add(cur);
        }
        List<List<String>> res = new LinkedList<>();
        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }
    
    private String encode(String cur) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <cur.length(); ++i) {
            int diff = cur.charAt(i) - cur.charAt(i - 1);
            if (diff < 0) {
                diff += 26;
            }
            sb.append((char)diff);
        }
        return sb.toString();
    }
}
