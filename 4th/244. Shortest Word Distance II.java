class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1), l2 = map.get(word2);
        int i = 0, j = 0;
        
        while (i < l1.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            while (j < l2.size() - 1 && l1.get(i) > l2.get(j)) {
                j++;
                res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            }
            i++;
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
