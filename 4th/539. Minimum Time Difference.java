class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] mins = new int[timePoints.size()];
        for (int i = 0; i < mins.length; ++i) {
            String t = timePoints.get(i);
            mins[i] = Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3, 5));
        }
        Arrays.sort(mins);
        int res = mins[0] + 24 * 60 - mins[mins.length - 1];
        for (int i = 0; i < mins.length - 1; ++i) {
            res = Math.min(res, mins[i + 1] - mins[i]);
        }
        return res;
    }
}
