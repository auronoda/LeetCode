public class ZigzagIterator {
    Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (v1 != null && v1.size() > 0) {
            queue.add(v1.iterator());
        }
        if (v2 != null && v2.size() > 0) {
            queue.add(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> itor = queue.poll();
        int res = itor.next();
        if (itor.hasNext()) {
            queue.add(itor);
        }
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty(); 
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
