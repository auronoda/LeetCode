class Solution {
    public String originalDigits(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            counts[s.charAt(i) - 'a']++;
        }
        int[] res = new int[10];
        res[0] = counts['z' - 'a'];
        res[2] = counts['w' - 'a'];
        res[4] = counts['u' - 'a'];
        res[5] = counts['f' - 'a'] - res[4];
        res[6] = counts['x' - 'a'];
        res[7] = counts['v' - 'a'] - res[5];
        res[8] = counts['g' - 'a'];
        res[3] = counts['r' - 'a'] - res[0] - res[4];
        res[1] = counts['o' - 'a'] - res[0] - res[2] - res[4];
        res[9] = counts['i' - 'a'] - res[5] - res[6] - res[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; ++i) {
            for (int j = 0; j < res[i]; ++j) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
    
}
