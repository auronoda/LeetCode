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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        PriorityQueue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });
        
        for (List<Interval> list: schedule) {
            heap.addAll(list);
        }
        
        List<Interval> res = new LinkedList<>();
        if (heap.isEmpty()) {
            return res;
        }
        int end = heap.poll().end;
        
        while (!heap.isEmpty()) {
            Interval cur = heap.poll();
            if (cur.start > end) {
                res.add(new Interval(end, cur.start));
            }
            end = Math.max(end, cur.end);
        }
        
        return res;
    }
}
