class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0; 
        Integer prev = null;
        for (int cur: timeSeries) {
            if (prev != null) {
                if (cur - prev > duration) {
                    res += duration;
                }
                else {
                    res += cur - prev;
                }
            }
            prev = cur;
        }
        if (prev != null) {
            res += duration;
        }        
        return res;
    }
}
