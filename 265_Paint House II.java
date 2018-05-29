class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int min = 0;
        int second = 0;
        int index = -1;
        
        for (int i = 0; i < n; ++i) {
            int newMin = Integer.MAX_VALUE;
            int newSecond = Integer.MAX_VALUE;
            int newIndex = -1;
            
            for (int j = 0; j < k; ++j) {
                int cur;
                if (j == index) {
                    cur = second + costs[i][j];
                }
                else {
                    cur = min + costs[i][j];
                }
                
                if (cur < newMin) {
                    newSecond = newMin;
                    newIndex = j;
                    newMin = cur;
                }
                else {
                    newSecond = Math.min(newSecond, cur);
                }
            }
            min = newMin;
            second = newSecond;
            index = newIndex;
        }
        
        return min;
    }
}
