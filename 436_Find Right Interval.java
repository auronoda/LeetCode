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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i].start, i);
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            res[map.get(intervals[i].start)] = bs(intervals, intervals[i].end, map);
        }
        
        return res;
    }
    
    private int bs(Interval[] intervals, int target, Map<Integer, Integer> map) {
        int start = 0, end = intervals.length - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (intervals[mid].start == target) {
                return map.get(intervals[mid].start);
            }
            if (intervals[mid].start < target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return intervals[start].start >= target? map.get(intervals[start].start): -1;
    }
}
