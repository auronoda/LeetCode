class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int count: map.values()) {
            if (res % 2 == 0 &&count % 2 == 1) {
                res++;
            }
            res += count / 2 * 2;
        }
        return res;
    }
}
