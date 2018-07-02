class Solution {
    public boolean canWin(String s) {
        return helper(s.toCharArray(), new HashMap<>());
    }
    
    private boolean helper(char[] chars, Map<String, Boolean> map) {
        if (map.containsKey(new String(chars))) {
            return map.get(new String(chars));
        }
        for (int i = 0; i < chars.length - 1; ++i) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                if (!helper(chars, map)) {
                    chars[i] = '+';
                    chars[i + 1] = '+';
                    return true;
                }
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }
        map.put(new String(chars), false);
        return false;
    }
}
