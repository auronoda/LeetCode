class Solution {
    public int minStickers(String[] stickers, String target) {
        int l = target.length();
        int n = 1 << l;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int state = 0; state < n; ++state) {
            if (dp[state] == Integer.MAX_VALUE) {
                continue;
            }
            
            for (String sticker: stickers) {
                int tmp = state;
                for (char c: sticker.toCharArray()) {
                    for (int i = 0; i < l; ++i) {
                        if (((tmp >> i) & 1) == 0 && target.charAt(i) == c) {
                            tmp |= 1 << i;
                            break;
                        }
                    }
                }
                
                dp[tmp] = Math.min(dp[tmp], dp[state] + 1);
            }
        }
        
        return dp[n - 1] ==  Integer.MAX_VALUE? -1: dp[n - 1];
    }
}
