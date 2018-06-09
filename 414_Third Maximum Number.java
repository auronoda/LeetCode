class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i: nums) {
            if (!set.add(i)) {
                continue;
            }
            heap.add(i);
            if (heap.size() > 3) {
                heap.poll();
            }
        }
        if (heap.size() == 3) {
            return heap.poll();
        }
        while (heap.size() > 1) {
            heap.poll();
        } 
        return heap.poll();
    }
}
