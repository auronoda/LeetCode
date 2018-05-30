class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] dp = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int index = i, count = 0, len = 0;
            while (len + sentence[index % n].length() <= cols) {
                len += sentence[index % n].length() + 1;
                index++;
                count++;
            }
            dp[i] = count;
        }
        
        int words = 0, index = 0;
        for (int i = 0; i < rows; ++i) {
            words += dp[index];
            index = (index + dp[index]) % n;
        }
        return words / n;
    }
}
