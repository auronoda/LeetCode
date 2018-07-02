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
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> (a.end - b.end));
        int end = Integer.MIN_VALUE;
        int res = 0;
        for (Interval cur: intervals) {
            if (cur.start >= end) {
                end = cur.end;
            }
            else {
                res++;
            }
        }
        return res;
    }
}
