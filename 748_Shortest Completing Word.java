class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] chars = new int[26];
        int count = 0;
        for (int i = 0; i < licensePlate.length(); ++i) {
            char c = licensePlate.charAt(i);
            if (c >= 'a' && c <= 'z') {
                chars[c - 'a']++;
                if (chars[c - 'a'] == 1) {
                    count++;
                }
            }
            else if (c >= 'A' && c <= 'Z') {
                chars[c - 'A']++;
                if (chars[c - 'A'] == 1) {
                    count++;
                }
            }
        }
        
        String res = "";
        int min = Integer.MAX_VALUE;
        
        for (String cur: words) {
            if (cur.length() >= min) {
                continue;
            }
            int[] tmpChars = chars.clone();
            int tmpCount = count;
            for (int i = 0; i < cur.length(); ++i) {
                char c = cur.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    tmpChars[c - 'a']--;
                    if (tmpChars[c - 'a'] == 0) {
                        tmpCount--;
                    }
                }
            }
            if (tmpCount == 0) {
                res = cur;
                min = cur.length();
            }
        }
        
        return res;
    }
}
