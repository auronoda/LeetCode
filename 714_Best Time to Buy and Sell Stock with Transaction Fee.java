class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buys = new int[n];
        int[] sells = new int[n];
        buys[0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i] - fee);
            buys[i] = Math.max(buys[i - 1], sells[i - 1] - prices[i]);
        }
        
        return sells[n - 1];
    }
}
