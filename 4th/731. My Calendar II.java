class MyCalendarTwo {
    List<int[]> overlaps;
    List<int[]> events;

    public MyCalendarTwo() {
        overlaps = new ArrayList<>();
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] cur: overlaps) {
            if (cur[0] < end && start < cur[1]) {
                return false;
            }
        }
        for (int[] cur: events) {
            if (cur[0] < end && start < cur[1]) {
                overlaps.add(new int[]{Math.max(start, cur[0]), Math.min(end, cur[1])});
            }
        }
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
