class MyCalendar {
    List<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] cur: events) {
            if (start < cur[1] && cur[0] < end) {
                return false;
            }
        }
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
