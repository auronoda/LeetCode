class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] mins = new int[timePoints.size()];
        for (int i = 0; i < mins.length; ++i) {
            String[] strs = timePoints.get(i).split(":");
            mins[i] = Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);
        }
        Arrays.sort(mins);
        
        int res = 1440 + mins[0] - mins[mins.length - 1];
        for (int i = 1; i < mins.length; ++i) {
            res = Math.min(res, mins[i] - mins[i - 1]);
        }
        return res;
    }
}
