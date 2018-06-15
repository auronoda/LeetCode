class MyCalendarTwo {
    List<int[]> overlaps;
    List<int[]> intervals;

    public MyCalendarTwo() {
        overlaps = new ArrayList<>();
        intervals = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] cur: overlaps) {
            if (cur[0] < end && start < cur[1]) {
                return false;
            }
        }
        for (int[] cur: intervals) {
            if (cur[0] < end && start < cur[1]) {
                overlaps.add(new int[]{Math.max(cur[0], start), Math.min(cur[1], end)});
            }
        }
        intervals.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
