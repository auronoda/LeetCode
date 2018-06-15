class HitCounter {
    Queue<Integer> queue;
    Map<Integer, Integer> map;
    int count;

    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
        map = new HashMap<>();
        count = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (map.containsKey(timestamp)) {
            map.put(timestamp, map.get(timestamp) + 1);
        }
        else {
            map.put(timestamp, 1);
            queue.add(timestamp);
        }
        count++;
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            count -= map.get(queue.peek());
            map.remove(queue.poll());
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            count -= map.get(queue.peek());
            map.remove(queue.poll());
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
