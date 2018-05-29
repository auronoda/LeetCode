class Solution {
    public int minCost(int[][] costs) {
        
        int n = costs.length;
        int min = 0;
        int second = 0;
        int index = -1;
        
        for (int i = 0; i < n; ++i) {
            int newMin = Integer.MAX_VALUE;
            int newSecond = Integer.MAX_VALUE;
            int newIndex = -1;
            
            for (int j = 0; j < 3; ++j) {
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
