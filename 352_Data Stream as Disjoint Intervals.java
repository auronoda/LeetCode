/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
    List<Interval> list;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        list = new ArrayList<>();
    }
    
    public void addNum(int val) {
        if (list.size() == 0) {
            list.add(new Interval(val, val));
            return;
        }

        int i = 0;
        while (i < list.size() && list.get(i).end < val) {
            ++i;
        }
        if (i < list.size() && list.get(i).start <= val) {
            return;
        }

        int equal = 0;
        if (i < list.size() && list.get(i).start == val + 1) {
            list.get(i).start = val;
            equal++;
        }
        if (i > 0 && list.get(i - 1).end == val - 1) {
            list.get(i - 1).end = val;
            equal++;
        }
        if (equal == 0) {
            list.add(i, new Interval(val, val));
        }
        else if (equal == 2) {
            list.get(i - 1).end = list.get(i).end;
            list.remove(i);
        }
        return;
        
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
