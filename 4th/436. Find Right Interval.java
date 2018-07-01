/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            list.add(new int[]{intervals[i].start, intervals[i].end, i});
        }
        Collections.sort(list, (a,b) -> a[0] - b[0]);
        int[] res = new int[intervals.length];
        for (int[] cur: list) {
            res[cur[2]] = bs(list, cur[1]);
        }
        return res;
    }
    private int bs(List<int[]> list, int target) {
        int start = 0, end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid)[0] >= target) {
                end = mid;
            }
            else {
                start = mid + 1; 
            }
        }
        if (list.get(start)[0] >= target) {
            return list.get(start)[2];
        }
        return -1;
    }
}
