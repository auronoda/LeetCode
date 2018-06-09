class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split(" ");
        String res = "";
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String word: banned) {
            set.add(word);
        }
        for (String word: words) {
            int end = word.length() - 1;
            while (!Character.isLetter(word.charAt(end))) {
                end--;
            }
            word = word.substring(0, end + 1);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word: map.keySet()) {
            if (!set.contains(word) && map.get(word) > max) {
                max = map.get(word);
                res = word;
            }
        }
        return res;
    }
}
