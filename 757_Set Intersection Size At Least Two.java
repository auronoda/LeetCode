class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, ((a,b) -> a[1] == b[1]? b[0] - a[0]: a[1] - b[1]));
        
        int res = 0, first = -1, second = -2;
        for (int[] cur: intervals) {
            if (second >= cur[0]) {
                continue;
            }
            if (first >= cur[0]) {
                second = first;
            }
            else {
                second = cur[1] - 1;
                res += 1;
            }
            first = cur[1];
            res += 1;
        }
        return res;
    }
}
