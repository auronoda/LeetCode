class ExamRoom {
    int N;
    TreeSet<Integer> students;

    public ExamRoom(int N) {
        this.N = N;
        students = new TreeSet<>();
    }
    
    public int seat() {
        if (students.size() == 0) {
            students.add(0);
            return 0;
        }
        int dis = 0;
        Integer prev = null;
        int res = 0;
        for (int cur: students) {
            if (prev == null) {
                dis = cur;
                res = 0;
            }
            else {
                if ((cur - prev) / 2 > dis) {
                    res = prev + (cur - prev) / 2;
                    dis = (cur - prev) / 2;
                }
            }
            prev = cur;
            
        }
        if (N - 1 - prev > dis) {
            res = N - 1;
        }
        students.add(res);
        return res;
    }
    
    public void leave(int p) {
        students.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
