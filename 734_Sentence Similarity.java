class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair: pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new HashSet<>());
            }
            map.get(pair[0]).add(pair[1]);
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new HashSet<>());
            }
            map.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < words1.length; ++i) {
            String s = words1[i], t = words2[i];
            if (s.equals(t)) {
                continue;
            }
            if (!map.containsKey(s)) {
                return false;
            }
            if (!map.get(s).contains(t)) {
                return false;
            }
        }
        
        return true;
    }
}
