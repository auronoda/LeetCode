class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int res = 0;
        Integer prev = null;
        for (int cur: timeSeries) {
            if (prev != null) {
                res += Math.min(duration, cur - prev);
            }
            prev = cur;
        }
        res += duration;
        return res;
    }
}
